package com.jemaystermind.freelancerinterview.ui.profile.details

data class ProfileDetails(val summary: String,
    val skills: List<SkillViewModel>,
    val exams: List<ExamViewModel>,
    val currentSkillCount: Int = 0,
    val maxSkillCount: Int = 0,
    val titleAbout: String,
    val titleSkills: String,
    val titleExam: String
)
