/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview

import com.jemaystermind.freelancerinterview.data.DataModule
import com.jemaystermind.freelancerinterview.ui.UserComponent
import com.jemaystermind.freelancerinterview.ui.UserModule
import dagger.Component
import javax.inject.Singleton

/**
 * Root of all components.
 */
@Singleton
@Component(
    modules = arrayOf(AndroidModule::class, DataModule::class)
)
interface ApplicationComponent {
  fun inject(application: FreelancerApp)

  fun plus(userModule: UserModule): UserComponent
}
