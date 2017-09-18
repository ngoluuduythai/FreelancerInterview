/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui.profile

import com.jemaystermind.freelancerinterview.ActivityScope
import com.jemaystermind.freelancerinterview.data.ApiProfileRepository
import com.jemaystermind.freelancerinterview.data.FreelancerApi
import dagger.Module
import dagger.Provides

/**
 * We provide all specific bindings to our Profile here.
 */
@Module
class ProfileModule {

//  @Provides
//  @ActivityScope
//  fun provideProfileRepository(database: SQLiteDatabase): ProfileRepository =
//      SqliteProfileRepository(database)

  @Provides
  @ActivityScope
  fun provideProfileRepository(api: FreelancerApi): ProfileRepository = ApiProfileRepository(api)

  @Provides
  @ActivityScope
  fun provideProfilePresenter(repository: ProfileRepository): ProfilePresenter =
      ProfilePresenter(repository)
}
