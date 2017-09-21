/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.data

import android.database.sqlite.SQLiteDatabase
import com.jemaystermind.freelancerinterview.data.api.model.Profile
import com.jemaystermind.freelancerinterview.ui.profile.ProfileRepository
import io.reactivex.Observable

/**
 * A Profile repository that retrieves a profile from the local database.
 */
class SqliteProfileRepository(val database: SQLiteDatabase) : ProfileRepository {
  override fun getProfile(username: String): Observable<Profile> {
    TODO("not implemented")
  }
}
