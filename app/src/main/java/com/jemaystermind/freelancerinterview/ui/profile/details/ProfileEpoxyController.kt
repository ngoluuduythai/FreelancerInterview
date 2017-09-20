package com.jemaystermind.freelancerinterview.ui.profile.details

import com.airbnb.epoxy.EpoxyController

class ProfileEpoxyController : EpoxyController() {
  override fun buildModels() {
    add(HeaderModel("My Skills"))

    add(listOf(SkillModel(SkillViewModel(true, "User Interface Design")),
        SkillModel(SkillViewModel(true, "User Experience Design"))))

    add(AddMoreSkillModel(5, 250))

    add(HeaderModel("My Exams"))

    add(listOf(ExamModel(ExamViewModel(true, "Aussie English G'day Mate!", 30)),
        ExamModel(ExamViewModel(true, "SketchApp", 50))))

    add(AddMoreExamModel())
  }
}
