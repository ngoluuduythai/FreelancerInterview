/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.data

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Endpoints offered by Freelancer.com API
 *
 * @author Jeremy Tecson
 */
interface FreelancerService {

  @GET("/{username}")
  fun profile(@Path("username") username: String): Observable<String>
}
