/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.injection.ui

import com.jemaystermind.freelancerinterview.injection.UserScope
import dagger.Subcomponent

@Subcomponent(
    modules = arrayOf(UserModule::class)
)
@UserScope
interface UserComponent {
  fun plus(module: ControllerModule): ControllerComponent
}
