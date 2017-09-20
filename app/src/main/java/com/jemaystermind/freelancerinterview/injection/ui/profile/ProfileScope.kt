package com.jemaystermind.freelancerinterview.injection.ui.profile

import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME

/**
 * A scope for instances which lives during the [ProfileController]'s lifetime.
 */
@Scope
@Retention(RUNTIME)
annotation class ProfileScope
