/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.injection.ui.profile

import com.jemaystermind.freelancerinterview.ui.profile.ProfileController
import dagger.Subcomponent

@ProfileScope
@Subcomponent(modules = arrayOf(
    ProfileModule::class))
interface ProfileComponent {
  fun inject(controller: ProfileController)
}
