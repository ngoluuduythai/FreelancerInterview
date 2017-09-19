/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui.profile

import android.os.Bundle
import com.jemaystermind.freelancerinterview.R.layout
import com.jemaystermind.freelancerinterview.data.FreelancerApi
import com.jemaystermind.freelancerinterview.data.User
import com.jemaystermind.freelancerinterview.ui.BaseActivity
import com.jemaystermind.freelancerinterview.ui.app
import timber.log.Timber
import javax.inject.Inject

class ProfileActivity : BaseActivity(), ProfileView {

  private val component: ProfileComponent by lazy {
    val component = app.userComponent ?: throw IllegalStateException("User component should not be null")
    component.plus(ProfileModule())
  }

  @Inject
  lateinit var api: FreelancerApi

  @Inject
  lateinit var user: User

  @Inject
  lateinit var presenter: ProfilePresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)
    component.inject(this)
    presenter.attachView(this)

    presenter.loadProfile(user.username)
  }

  override fun showProgress(show: Boolean) {
    Timber.i("Showing progress")
  }
}
