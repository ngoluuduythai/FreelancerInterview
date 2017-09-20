package com.jemaystermind.freelancerinterview.ui

import com.jemaystermind.freelancerinterview.ActivityScope
import com.jemaystermind.freelancerinterview.ui.profile.ProfileComponent
import com.jemaystermind.freelancerinterview.ui.profile.ProfileModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(ControllerModule::class))
interface ControllerComponent {
  fun inject(activity: MainActivity)

  fun plus(module: ProfileModule): ProfileComponent
}
