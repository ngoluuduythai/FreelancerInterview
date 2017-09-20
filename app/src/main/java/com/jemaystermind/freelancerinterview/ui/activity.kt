/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui

import android.app.Activity
import com.jemaystermind.freelancerinterview.FreelancerApp

/**
 * An extension function that let us easily retrieve a [FreelancerApp] from any [Activity].
 */
val Activity.app: FreelancerApp
  get() = application as FreelancerApp
