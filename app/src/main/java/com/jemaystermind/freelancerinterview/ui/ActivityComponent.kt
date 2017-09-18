/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui

import com.jemaystermind.freelancerinterview.ActivityScope
import com.jemaystermind.freelancerinterview.ui.profile.ProfileActivity
import dagger.Subcomponent

@Subcomponent(
    modules = arrayOf(ActivityModule::class)
)
@ActivityScope
interface ActivityComponent {
  fun inject(activity: ProfileActivity)
}
