package com.jemaystermind.freelancerinterview.injection.ui

import com.jemaystermind.freelancerinterview.injection.ActivityScope
import com.jemaystermind.freelancerinterview.ui.MainActivity
import com.jemaystermind.freelancerinterview.injection.ui.profile.ProfileComponent
import com.jemaystermind.freelancerinterview.injection.ui.profile.ProfileModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(
    ControllerModule::class))
interface ControllerComponent {
  fun inject(activity: MainActivity)

  fun plus(module: ProfileModule): ProfileComponent
}
