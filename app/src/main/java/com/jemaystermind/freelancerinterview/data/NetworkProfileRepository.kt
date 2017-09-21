/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.data

import com.jemaystermind.freelancerinterview.data.api.model.Profile
import com.jemaystermind.freelancerinterview.ui.profile.ProfileRepository
import io.reactivex.Observable

class NetworkProfileRepository(private val api: FreelancerApi) : ProfileRepository {
  override fun getProfile(username: String): Observable<Profile> = api.profile(username)
}
