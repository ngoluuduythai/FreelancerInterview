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
