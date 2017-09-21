/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.data.api

import io.reactivex.Observable
import io.reactivex.Scheduler
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.Type

/**
 * A factory that applies an [ObserveOnMainCallAdapter] to [Observable] types only.
 */
class ObserveOnMainCallAdapterFactory(private val scheduler: Scheduler) : CallAdapter.Factory() {
  override fun get(returnType: Type?, annotations: Array<out Annotation>?,
      retrofit: Retrofit?): CallAdapter<Any, Any>? {

    if (getRawType(returnType) != Observable::class.java) {
      return null // Ignore non-Observable types
    }

    // Look up the next call adapter which would otherwise be used if this one was not present.
    @Suppress("UNCHECKED_CAST")
    val delegate = retrofit?.nextCallAdapter(this, returnType,
        annotations) as CallAdapter<Any, Observable<*>>

    return ObserveOnMainCallAdapter(scheduler, delegate)
  }
}
