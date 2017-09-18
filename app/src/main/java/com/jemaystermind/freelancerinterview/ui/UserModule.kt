package com.jemaystermind.freelancerinterview.ui

import com.jemaystermind.freelancerinterview.UserScope
import com.jemaystermind.freelancerinterview.data.User
import dagger.Module
import dagger.Provides

@Module
class UserModule(private val currentUser: User) {

  @Provides
  @UserScope
  fun provideCurrentUser() = currentUser
}
