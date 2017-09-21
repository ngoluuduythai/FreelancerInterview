/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.injection

import android.content.Context
import com.jemaystermind.freelancerinterview.FreelancerApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * A module for Android-specific dependencies which requires a [Context] or
 * [Application][android.app.Application] to create
 *
 * @author Jeremy Tecson
 */
@Module
class AndroidModule(private val application: FreelancerApp) {

  @Provides @Singleton
  fun provideApplicationContext(): Context = application

}
