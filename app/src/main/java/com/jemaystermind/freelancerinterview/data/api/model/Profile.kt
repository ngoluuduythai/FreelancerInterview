/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.data.api.model

import com.squareup.moshi.Json

data class Profile(
    val id: Long,
    val username: String = "",
    val about: String = "",
    val files: List<File> = emptyList(),
    val attachments: List<Attachment> = emptyList(),
    @Json(name = "bidperiod") val bidPeriod: Long = 0,
    val skills: List<Skill> = emptyList(),
    val exams: List<Exam> = emptyList(),
    @Json(name = "avatar") val avatarUrl: String = "",
    val coverPhotoUrl: String = "",
    val currentSkillCount: Int = 0,
    val maxSkillCount: Int = 0
)
