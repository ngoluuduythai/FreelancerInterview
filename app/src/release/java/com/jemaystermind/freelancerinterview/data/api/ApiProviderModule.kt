/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.data.api

import com.jemaystermind.freelancerinterview.data.FreelancerApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiProviderModule {
  /**
   * Provides our real API service
   */
  @Provides
  @Singleton
  fun provideFreelancerService(retrofit: Retrofit): FreelancerApi =
      retrofit.create(FreelancerApi::class.java)
}
