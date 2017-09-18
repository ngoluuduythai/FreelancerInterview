/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview

import android.app.Application
import com.jemaystermind.freelancerinterview.data.User
import com.jemaystermind.freelancerinterview.ui.UserComponent
import com.jemaystermind.freelancerinterview.ui.UserModule
import com.squareup.leakcanary.LeakCanary
import timber.log.Timber
import timber.log.Timber.DebugTree

class FreelancerApp : Application() {

  val applicationComponent: ApplicationComponent by lazy {
    DaggerApplicationComponent.create()
  }

  var userComponent: UserComponent? = null

  override fun onCreate() {
    super.onCreate()
    if (LeakCanary.isInAnalyzerProcess(this)) {
      // This process is dedicated to LeakCanary for heap analysis.
      // You should not init your app in this process.
      return
    }

    applicationComponent.inject(this)
    createUserComponent(User("DanaPotPlant"))

    LeakCanary.install(this)
    Timber.plant(DebugTree())
  }

  fun createUserComponent(user: User) {
    userComponent = applicationComponent.plus(UserModule(user))
  }

  fun releaseUserComponent() {
    userComponent = null
  }
}
