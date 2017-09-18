/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.data.api

import io.reactivex.Observable
import io.reactivex.Scheduler
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

/**
 * An adapter for our http calls that sets a default [Scheduler] on [Observable.observeOn].
 *
 * With this, we can safely assume that [Observable.observeOn] is called on the specified [Scheduler].
 */
class ObserveOnMainCallAdapter(private val scheduler: Scheduler,
    private val delegate: CallAdapter<Any, Observable<*>>) : CallAdapter<Any, Any> {
  // Delegate to get the normal Observable
  // and change it to send notifications to the observer on the specified scheduler.
  override fun adapt(call: Call<Any>?): Observable<out Any> {
    val observable: Observable<*> = delegate.adapt(call)
    return observable.observeOn(scheduler)
  }

  override fun responseType(): Type = delegate.responseType()
}
