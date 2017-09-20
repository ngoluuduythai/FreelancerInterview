/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.data.api

import com.jemaystermind.freelancerinterview.data.FreelancerApi
import com.jemaystermind.freelancerinterview.data.api.model.Exam
import com.jemaystermind.freelancerinterview.data.api.model.Profile
import com.jemaystermind.freelancerinterview.data.api.model.Skill
import io.reactivex.Observable
import retrofit2.mock.BehaviorDelegate

class MockFreelancerApi(private val delegate: BehaviorDelegate<FreelancerApi>) :
    FreelancerApi {

  private val danapotplantProfile: Profile = Profile("DanaPotPlant",
      about = "Hi, I'm Dana, a pot plant. I love to pot plant myself in a pot. It is a very refreshing feeling. We will really work well together.",
      bidPeriod = 7,
      skills = listOf(Skill("User Interface Design"), Skill("User Experience Design")),
      exams = listOf(Exam("Aussie English G'Day Mate!", 80), Exam("SketchApp", 30)),
      avatarUrl = "https://i.imgur.com/DvpvklR.png"
//      currentSkillCount = 5,
//      maxSkillCount = 250
  )
  private val emptyProfile = Profile()

  override fun profile(username: String): Observable<Profile> {
    val profile: Profile = when (username.toLowerCase()) {
      "danapotplant" -> danapotplantProfile
      else -> emptyProfile
    }

    return delegate.returningResponse(profile).profile(username)
  }
}
