/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui

import com.jemaystermind.freelancerinterview.UserScope
import com.jemaystermind.freelancerinterview.ui.profile.ProfileComponent
import com.jemaystermind.freelancerinterview.ui.profile.ProfileModule
import dagger.Subcomponent

@Subcomponent(
    modules = arrayOf(UserModule::class)
)
@UserScope
interface UserComponent {
  fun plus(module: ProfileModule): ProfileComponent
}
