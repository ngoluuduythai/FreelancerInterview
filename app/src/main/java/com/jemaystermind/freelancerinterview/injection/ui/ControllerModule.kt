/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.injection.ui

import android.app.Activity
import android.os.Bundle
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.jemaystermind.freelancerinterview.injection.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class ControllerModule(private val activity: Activity, private val container: ViewGroup,
    private val bundle: Bundle?) {

  @Provides
  @ActivityScope
  fun provideRouter(): Router =
      Conductor.attachRouter(activity, container, bundle)
}
