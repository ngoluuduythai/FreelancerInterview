/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui.profile

import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
import android.support.design.widget.TabLayout.OnTabSelectedListener
import android.support.design.widget.TabLayout.Tab
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import butterknife.BindView
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.support.RouterPagerAdapter
import com.jemaystermind.freelancerinterview.R
import com.jemaystermind.freelancerinterview.injection.ui.profile.ProfileComponent
import com.jemaystermind.freelancerinterview.injection.ui.profile.ProfileModule
import com.jemaystermind.freelancerinterview.ui.ButterKnifeController
import com.jemaystermind.freelancerinterview.ui.GlideApp
import com.jemaystermind.freelancerinterview.ui.MainActivity
import com.jemaystermind.freelancerinterview.ui.disable
import com.jemaystermind.freelancerinterview.ui.enable
import com.jemaystermind.freelancerinterview.ui.inflate
import com.jemaystermind.freelancerinterview.ui.profile.ProfileController.TabItems.PROFILE
import com.jemaystermind.freelancerinterview.ui.profile.ProfileController.TabItems.REVIEW
import com.jemaystermind.freelancerinterview.ui.profile.details.ProfileDetails
import com.jemaystermind.freelancerinterview.ui.profile.details.ProfileDetailsController
import com.jemaystermind.freelancerinterview.ui.profile.review.ReviewController
import com.jemaystermind.freelancerinterview.ui.toggle
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Provider

class ProfileController : ButterKnifeController, ProfileContract.View {

  // Note: The order affects the order of the tabs displayed too!
  // We want to add the "Profile" details on the first tab and
  // the "Review" on the second tab
  private enum class TabItems {
    PROFILE, REVIEW
  }

  /**
   * Used when this [Controller][ProfileController] is recreated.
   */
  constructor() : super()

  constructor(username: String) : super(Bundle().apply {
    putString("username", username)
  })

  init {
    setHasOptionsMenu(true)
  }

  var profileComponent: ProfileComponent? = null

  @Inject
  lateinit var presenter: ProfileContract.Presenter

  @Inject
  lateinit var profileDetailsControllerProvider: Provider<ProfileDetailsController>
  lateinit var currentProfileDetailsController: ProfileDetailsController

  @Inject
  lateinit var reviewControllerProvider: Provider<ReviewController>
  lateinit var currentReviewController: ReviewController

  // Wanted to use kotlin android extensions
  // but it looks ugly when using it outside the view inflation. So many ???
  @BindView(R.id.toolbar)
  lateinit var toolbar: Toolbar

  @BindView(R.id.tabs)
  lateinit var tabs: TabLayout

  @BindView(R.id.pager)
  lateinit var pager: ViewPager

  @BindView(R.id.profile_photo)
  lateinit var profilePhoto: ImageView

  @BindView(R.id.save_profile)
  lateinit var saveProfile: Button

  @BindView(R.id.name)
  lateinit var name: TextView

  @BindView(R.id.handle)
  lateinit var handle: TextView

  @BindView(R.id.progress)
  lateinit var loadingBar: ProgressBar

  @BindView(R.id.header_profile_container)
  lateinit var headerContainer: ViewGroup

  @BindView(R.id.collapsing_toolbar)
  lateinit var collapsingToolbar: CollapsingToolbarLayout

  @BindView(R.id.coordinator)
  lateinit var coordinatorLayout: CoordinatorLayout

  lateinit var username: String

  private lateinit var pageAdapter: RouterPagerAdapter

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
    profileComponent = (activity as MainActivity).controllerComponent
        .plus(ProfileModule())
    profileComponent?.inject(this)
    return super.onCreateView(inflater, container)
  }

  override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View =
      container.inflate(R.layout.controller_profile)

  override fun onViewBound(view: View) {
    presenter.attachView(this)

    username = args.getString("username")

    setupActionBar()
    setupViewpager()
    setupTabs()
  }

  override fun onAttach(view: View) {
    presenter.loadProfile(username)
  }

  override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
    inflater.inflate(R.menu.menu_profile, menu)
    super.onCreateOptionsMenu(menu, inflater)
  }

  override fun onDestroyView(view: View) {
    presenter.detachView()
    profileComponent = null

    if (!activity?.isChangingConfigurations!!) {
      pager.adapter = null
    }
    tabs.setupWithViewPager(null)
    super.onDestroyView(view)
  }

  private fun setupViewpager() {
    pageAdapter = object : RouterPagerAdapter(this) {

      override fun configureRouter(router: Router, position: Int) {
        Timber.i("Configuring controller for position $position")
        if (!router.hasRootController()) {
          val tabPosition = TabItems.values()[position]
          val controller = when (tabPosition) {
            PROFILE -> profileDetailsControllerProvider.get().also {
              currentProfileDetailsController = it
            }

            REVIEW -> reviewControllerProvider.get().also {
              currentReviewController = it
            }
          }
          router.setRoot(RouterTransaction.with(controller))
        }
      }

      override fun getCount(): Int = TabItems.values().size

      override fun getPageTitle(position: Int): CharSequence {
        val tabPosition = TabItems.values()[position]
        return when (tabPosition) {
          PROFILE -> activity?.getString(R.string.title_tab_profile)!!
          REVIEW -> activity?.getString(R.string.title_tab_review)!!
        }
      }
    }

    pager.adapter = pageAdapter
  }

  private fun setupTabs() {
    tabs.setupWithViewPager(pager)

    // Show/Hide "Save Profile" depending on the tab selected
    // Not sure if it's the best way of animating this view. ¯\_(ツ)_/¯
    tabs.addOnTabSelectedListener(object : OnTabSelectedListener {
      val posY = saveProfile.translationY

      override fun onTabSelected(tab: Tab) {
        val tabPosition = TabItems.values()[tab.position]
        when (tabPosition) {
          PROFILE -> {
            saveProfile.enable()
            saveProfile.animate().translationY(posY)
          }

          REVIEW -> {
            // Making sure save can't be triggered
            saveProfile.disable()
            saveProfile.animate().translationY(saveProfile.translationY + saveProfile.height)
          }
        }
      }

      override fun onTabUnselected(tab: Tab?) {
        // Do nothing
      }

      override fun onTabReselected(tab: Tab?) {
        // Do nothing
      }
    })
  }

  private lateinit var profileDetails: ProfileDetails

  private fun setupActionBar() {
    val appCompatActivity = activity as AppCompatActivity
    appCompatActivity.setSupportActionBar(toolbar)
    val supportActionBar = appCompatActivity.supportActionBar

    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)
    supportActionBar?.setDisplayShowTitleEnabled(false)
  }

  override fun showProgress(show: Boolean) {
    if (isDestroyed)
      return

    // Show/hide loading bar
    loadingBar.toggle(show)

    // Show/Hide content depending if the loading bar's visibility
    pager.visibility = if (show) View.INVISIBLE else View.VISIBLE
    saveProfile.toggle(!show)
    collapsingToolbar.toggle(!show) // TODO Jemay: Show the action bar when the loading bar is shown
  }

  override fun showErrorProfileRetrieval() {
    if (isDestroyed)
      return

    // Show a snack bar with a "Try again" option
    Snackbar.make(coordinatorLayout, R.string.error_profile_retrieval, Snackbar.LENGTH_INDEFINITE)
        .setAction(R.string.message_try_again) {
          presenter.retryProfileRetrieval(username)
        }
        .setActionTextColor(ContextCompat.getColor(activity, R.color.green))
        .show()
  }

  override fun updateProfile(profile: ProfileViewModel) {
    if (isDestroyed)
      return

    // Update profile picture
    GlideApp.with(activity)
        .load(profile.profilePhotoUrl)
        .placeholder(R.drawable.profile)
        .fitCenter()
        .centerCrop()
        .into(profilePhoto)

    // Update name label
    name.text = profile.name

    // Update handle label
    handle.text = profile.handle

    // Update our profile details
    val summary = profile.about
    val skills = profile.skills
    val currentSkillCount = profile.currentSkillCount
    val maxSkillCount = profile.maxSkillCount
    val exams = profile.exams
    val titleAbout = activity?.getString(R.string.header_title_about)!!
    val titleSkills = activity?.getString(R.string.header_title_skills)!!
    val titleExams = activity?.getString(R.string.header_title_exam)!!

    val profileDetails = ProfileDetails(summary, skills, exams, currentSkillCount, maxSkillCount,
        titleAbout, titleSkills, titleExams)

    this.profileDetails = profileDetails
    currentProfileDetailsController.updateProfileDetails(profileDetails)
  }
}
