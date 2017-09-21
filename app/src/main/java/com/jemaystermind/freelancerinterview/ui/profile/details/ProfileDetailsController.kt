/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui.profile.details

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jemaystermind.freelancerinterview.R
import com.jemaystermind.freelancerinterview.ui.ButterKnifeController
import com.jemaystermind.freelancerinterview.ui.inflate
import kotlinx.android.synthetic.main.controller_profile_details.view.recyler

class ProfileDetailsController : ButterKnifeController {

  /**
   * Used when this [Controller][ProfileDetailsController] is recreated.
   */
  constructor() : super()

  constructor(bundle: Bundle): super(bundle)

  private val epoxyController = ProfileEpoxyController()

  override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View =
      container.inflate(R.layout.controller_profile_details)

  override fun onViewBound(view: View) {
    view.recyler.layoutManager = LinearLayoutManager(activity)
    view.recyler.adapter = epoxyController.adapter
  }

  fun updateProfileDetails(details: ProfileDetails) {
    epoxyController.setData(details)
  }
}
