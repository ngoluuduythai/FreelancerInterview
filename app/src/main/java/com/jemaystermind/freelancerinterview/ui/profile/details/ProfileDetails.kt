/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

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
