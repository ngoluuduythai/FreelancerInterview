/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui.profile.details

import com.airbnb.epoxy.AutoModel
import com.airbnb.epoxy.TypedEpoxyController

class ProfileEpoxyController : TypedEpoxyController<ProfileDetails>() {

  // It's better to add thiThis models doesn't changed
  @AutoModel lateinit var aboutModel: AboutDetailsModel_
  @AutoModel lateinit var addMoreSkillsModel: AddMoreSkillModel_
  @AutoModel lateinit var addMoreExamModel: AddMoreExamModel_
  @AutoModel lateinit var headerAboutModel: HeaderModel_
  @AutoModel lateinit var headerSkillsModel: HeaderModel_
  @AutoModel lateinit var headerExamModel: HeaderModel_

  override fun buildModels(details: ProfileDetails) {
    // About section
    headerAboutModel.title(details.titleAbout).addTo(this)
    aboutModel.details(details.summary).addTo(this)

    // Skills section
    headerSkillsModel.title(details.titleSkills).addTo(this)

    // Add the skills view model after converting
    details.skills.map {
      SkillModel_().id("skills", it.id)
          .skill(it)
    }.forEach { it.addTo(this) }

    addMoreSkillsModel.currentSkillCount(details.currentSkillCount)
        .maxSkillCount(details.maxSkillCount)
        .addTo(this)

    // Exam section
    headerExamModel.title(details.titleExam).addTo(this)

    // Add the exam view model after converting
    details.exams.map {
      ExamModel_().id("exams", it.id)
          .exam(it)
    }.forEach { it.addTo(this) }

    addMoreExamModel.addTo(this)
  }
}
