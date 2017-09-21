/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui.profile

import com.jemaystermind.freelancerinterview.data.api.model.Profile
import io.reactivex.Observable

/**
 * A repository that knows how to retrieve a user's profile
 */
interface ProfileRepository {
  fun getProfile(username: String): Observable<Profile>
}
