/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui.profile

import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber

/**
 * A presenter that knows how to handle our profile and interactions with a [ProfileContract.View].
 *
 * This presenter's jobs are the following:
 *
 * 1. It knows how to retrieve a profile from a [ProfileRepository].
 * 2. Converts the data from the presentation layer to our data layer and vice versa.
 */
class ProfilePresenter(private val repository: ProfileRepository) : ProfileContract.Presenter() {

  override fun loadProfile(username: String) {
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
