/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui.profile

import com.jemaystermind.freelancerinterview.ui.BasePresenter
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber

class ProfilePresenter(private val repository: ProfileRepository) : BasePresenter<ProfileView>() {

  fun loadProfile(username: String) {
    checkViewAttached()
    Timber.i("Loading the profile of $username")
    repository.getProfile(username)
        .doOnSubscribe {
          if (isViewAttached()) {
            view?.showProgress(true)
          }
        }
        .subscribeBy(
            onNext = {
              Timber.i("Profile=$it")
            },
            onError = {
              Timber.e("Error retrieving the profile of $username", it)
            }
        )
  }
}
