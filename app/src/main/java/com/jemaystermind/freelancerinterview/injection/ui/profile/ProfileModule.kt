/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.injection.ui.profile

import com.jemaystermind.freelancerinterview.data.NetworkProfileRepository
import com.jemaystermind.freelancerinterview.data.FreelancerApi
import com.jemaystermind.freelancerinterview.ui.profile.ProfileContract.Presenter
import com.jemaystermind.freelancerinterview.ui.profile.ProfilePresenter
import com.jemaystermind.freelancerinterview.ui.profile.ProfileRepository
import com.jemaystermind.freelancerinterview.ui.profile.details.ProfileDetailsController
import com.jemaystermind.freelancerinterview.ui.profile.review.ReviewController
import dagger.Module
import dagger.Provides

/**
 * We provide all specific bindings to our Profile here.
 */
@Module
class ProfileModule {

  @Provides
  @ProfileScope
  fun provideProfileRepository(api: FreelancerApi): ProfileRepository = NetworkProfileRepository(api)

  @Provides
  @ProfileScope
  fun provideProfilePresenter(repository: ProfileRepository): Presenter =
      ProfilePresenter(repository)

  @Provides
  fun provideProfileDetailsController(): ProfileDetailsController = ProfileDetailsController()

  @Provides
  fun provideReviewController(): ReviewController = ReviewController()
}
