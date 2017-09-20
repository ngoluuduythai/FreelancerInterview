package com.jemaystermind.freelancerinterview.ui.profile.details

import com.airbnb.epoxy.EpoxyController
import timber.log.Timber

class ProfileEpoxyController : EpoxyController() {
  private var about: String = ""
  private var skills = emptyList<SkillViewModel>()
  private var exams = emptyList<ExamViewModel>()
  private var currentSkillCount = 0
  private var maxSkillCount = 0

  fun setAboutDetails(about: String) {
    this.about = about
  }

  fun setSkills(skills: List<SkillViewModel>) {
    this.skills = skills
  }

  fun setExams(exams: List<ExamViewModel>) {
    this.exams = exams
  }

  fun updateSkillCount(currentSkillCount: Int, maxSkillCount: Int) {
    this.currentSkillCount = currentSkillCount
    this.maxSkillCount = maxSkillCount
  }

  override fun buildModels() {
    Timber.i("Building recyler models...")
    Timber.i("Skills=$skills")
    Timber.i("Exams=$exams")

    // About section
    add(HeaderModel("About"))
    add(AboutDetailsModel(about))

    // Skills section
    add(HeaderModel("My Skills"))
    add(skills.map { SkillModel(it) })
    add(AddMoreSkillModel(currentSkillCount, maxSkillCount))

    // Exam section
    add(HeaderModel("My Exams"))
    add(exams.map { ExamModel(it) })
    add(AddMoreExamModel())
  }
}
