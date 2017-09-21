/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.data.api

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = arrayOf(ApiProviderModule::class))
class ApiModule {

  @Provides
  @Singleton
  fun provideBaseUrl(): HttpUrl = HttpUrl.parse("http://www.freelancer.com/api/")!! // Code smell

  @Provides
  @Singleton
  fun provideHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
  }

  @Provides
  @Singleton
  fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()

  @Provides
  @Singleton
  fun provideRetrofit(baseUrl: HttpUrl, httpClient: OkHttpClient, moshi: Moshi,
      @Named("io") scheduler: Scheduler, @Named("main") mainThreadScheduler: Scheduler): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(httpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(ObserveOnMainCallAdapterFactory(mainThreadScheduler))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(scheduler))
        .build()
  }
}
