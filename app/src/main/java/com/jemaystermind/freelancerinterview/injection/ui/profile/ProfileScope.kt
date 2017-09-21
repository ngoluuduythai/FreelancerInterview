/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.injection.ui.profile

import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME

/**
 * A scope for instances which lives during the [ProfileController]'s lifetime.
 */
@Scope
@Retention(RUNTIME)
annotation class ProfileScope
