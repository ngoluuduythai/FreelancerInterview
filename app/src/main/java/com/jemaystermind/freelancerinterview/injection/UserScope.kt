/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.injection

import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME

/**
 * A scope for instances which lives during the "login" lifetime.
 */
@Scope
@Retention(RUNTIME)
annotation class UserScope
