/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui.profile

import com.jemaystermind.freelancerinterview.ui.profile.details.ExamViewModel
import com.jemaystermind.freelancerinterview.ui.profile.details.SkillViewModel

data class ProfileViewModel(val coverPhotoUrl: String = "",
    val profilePhotoUrl: String,
    val name: String,
    val handle: String,
    val about: String = "",
    val skills: List<SkillViewModel>,
    val exams: List<ExamViewModel>,
    val currentSkillCount: Int = 0,
    val maxSkillCount: Int = 0
)
