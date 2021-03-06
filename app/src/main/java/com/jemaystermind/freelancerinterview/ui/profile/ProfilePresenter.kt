/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui.profile

import com.jemaystermind.freelancerinterview.ui.profile.details.ExamViewModel
import com.jemaystermind.freelancerinterview.ui.profile.details.SkillViewModel
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
          view?.showProgress(true)
        }
        .doOnNext {
          view?.showProgress(false)
        }
        .map {
          val coverPhotoUrl = it.coverPhotoUrl
          val profilePhotoUrl = it.avatarUrl
          val name = it.username
          val handle = it.username
          val about = it.about
          val skills = it.skills.map { SkillViewModel(it.id, true, it.name) }
          val exams = it.exams.map { ExamViewModel(it.id, true, it.name, it.progress) }
          val currentSkillCount = it.currentSkillCount
          val maxSkillCount = it.maxSkillCount

          ProfileViewModel(coverPhotoUrl, profilePhotoUrl, name, handle, about, skills, exams,
              currentSkillCount, maxSkillCount)
        }
        .subscribeBy(
            onNext = {
              Timber.i("Profile retrieved the repository=$it")
              view?.updateProfile(it)
            },
            onError = {
              it.printStackTrace()
              Timber.e("Error retrieving the profile of $username", it)
              view?.showErrorProfileRetrieval()
            }
        )
  }

  override fun retryProfileRetrieval(username: String) {
    loadProfile(username)
  }
}
