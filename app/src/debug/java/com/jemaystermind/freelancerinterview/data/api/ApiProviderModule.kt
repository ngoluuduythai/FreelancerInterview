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
import retrofit2.mock.BehaviorDelegate
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior
import java.util.Random
import javax.inject.Singleton

/**
 * A fake API provider module for debugging
 */
@Module
class ApiProviderModule {

  @Provides
  @Singleton
  fun provideFreelancerService(delegate: BehaviorDelegate<FreelancerApi>): FreelancerApi =
      MockFreelancerApi(delegate)

  @Provides
  @Singleton
  fun provideBehaviorDelegate(mockRetrofit: MockRetrofit): BehaviorDelegate<FreelancerApi> =
      mockRetrofit.create(FreelancerApi::class.java)

  @Provides
  @Singleton
  fun providesMockRetrofit(retrofit: Retrofit, networkBehavior: NetworkBehavior): MockRetrofit =
      MockRetrofit.Builder(retrofit).networkBehavior(networkBehavior).build()

  @Provides
  @Singleton
  fun provideNetworkBehavior(): NetworkBehavior = NetworkBehavior.create(Random()).apply {
    setErrorPercent(50)
  }
}
