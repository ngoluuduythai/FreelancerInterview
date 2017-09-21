/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.data

import com.jemaystermind.freelancerinterview.data.api.ApiModule
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module(
    includes = arrayOf(ApiModule::class)
)
class DataModule {

  @Provides
  @Singleton
  fun provideMoshi(): Moshi = Moshi.Builder().build()

  @Provides
  @Singleton
  @Named("io")
  fun providesDefaultScheduler(): Scheduler = Schedulers.io()

  @Provides
  @Singleton
  @Named("main")
  fun providesMainThreadScheduler(): Scheduler = AndroidSchedulers.mainThread()
}
