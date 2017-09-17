/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui.profile

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jemaystermind.freelancerinterview.R.layout
import com.jemaystermind.freelancerinterview.data.FreelancerService
import com.jemaystermind.freelancerinterview.data.User
import com.jemaystermind.freelancerinterview.ui.ActivityComponent
import com.jemaystermind.freelancerinterview.ui.ActivityModule
import com.jemaystermind.freelancerinterview.ui.app
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber
import javax.inject.Inject

class ProfileActivity : AppCompatActivity() {

  private val activityComponent: ActivityComponent by lazy {
    val component = app.userComponent ?: throw IllegalStateException("User component should not be null")
    component.plus(ActivityModule())
  }

  @Inject
  lateinit var service: FreelancerService

  @Inject
  lateinit var user: User

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)
    activityComponent.inject(this)

    service.profile(user.username).subscribeBy(
        onNext = {
          Timber.i(it)
        },
        onError = {
          Timber.e("Error fetching the profile of ${user.username}", it)
        }
    )
  }
}
