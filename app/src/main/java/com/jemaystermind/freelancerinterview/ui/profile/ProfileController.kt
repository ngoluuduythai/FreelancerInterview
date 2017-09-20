package com.jemaystermind.freelancerinterview.ui.profile

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.design.widget.TabLayout.OnTabSelectedListener
import android.support.design.widget.TabLayout.Tab
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import butterknife.BindView
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.support.RouterPagerAdapter
import com.jemaystermind.freelancerinterview.R
import com.jemaystermind.freelancerinterview.injection.ui.profile.ProfileComponent
import com.jemaystermind.freelancerinterview.injection.ui.profile.ProfileModule
import com.jemaystermind.freelancerinterview.ui.ButterKnifeController
import com.jemaystermind.freelancerinterview.ui.MainActivity
import com.jemaystermind.freelancerinterview.ui.disable
import com.jemaystermind.freelancerinterview.ui.enable
import com.jemaystermind.freelancerinterview.ui.inflate
import com.jemaystermind.freelancerinterview.ui.profile.ProfileController.TabItems.PROFILE
import com.jemaystermind.freelancerinterview.ui.profile.ProfileController.TabItems.REVIEW
import com.jemaystermind.freelancerinterview.ui.profile.details.ProfileDetailsController
import com.jemaystermind.freelancerinterview.ui.profile.review.ReviewController
import kotlinx.android.synthetic.main.profile_header.view.username
import timber.log.Timber
import javax.inject.Inject

class ProfileController : ButterKnifeController, ProfileContract.View {

  // Note: The order affects the order of the tabs displayed too!
  // We want to add the "Profile" details on the first tab and
  // the "Review" on the second tab
  private enum class TabItems {
    PROFILE, REVIEW
  }

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

  @BindView(R.id.toolbar)
  lateinit var toolbar: Toolbar

  @BindView(R.id.pager)
  lateinit var pager: ViewPager

  @BindView(R.id.tabs)
  lateinit var tabs: TabLayout

  @BindView(R.id.save_profile)
  lateinit var saveProfile: Button

  lateinit var username: String

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
    profileComponent = (activity as MainActivity).controllerComponent.plus(
        ProfileModule())
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
    view.username.text = "Tok Hang"
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
    pager.adapter = object : RouterPagerAdapter(this) {
      override fun configureRouter(router: Router, position: Int) {
        val tabPosition = TabItems.values()[position]
        val controller = when (tabPosition) {
          PROFILE -> ProfileDetailsController()
          REVIEW -> ReviewController()
        }

        if (!router.hasRootController()) {
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

    // Show/Hide "Save Profile" depending on the tab selected
    tabs.addOnTabSelectedListener(object : OnTabSelectedListener{
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

    tabs.setupWithViewPager(pager)
  }

  private fun setupActionBar() {
    val appCompatActivity = activity as AppCompatActivity
    appCompatActivity.setSupportActionBar(toolbar)
    val supportActionBar = appCompatActivity.supportActionBar

    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)
    supportActionBar?.setDisplayShowTitleEnabled(false)
  }

  override fun showProgress(show: Boolean) {
    Timber.i("Show/hide progress")
  }
}
