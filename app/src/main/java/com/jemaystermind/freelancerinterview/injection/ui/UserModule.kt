/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.injection.ui

import com.jemaystermind.freelancerinterview.injection.UserScope
import com.jemaystermind.freelancerinterview.data.User
import dagger.Module
import dagger.Provides

@Module
class UserModule(private val currentUser: User) {

  @Provides
  @UserScope
  fun provideCurrentUser() = currentUser
}
