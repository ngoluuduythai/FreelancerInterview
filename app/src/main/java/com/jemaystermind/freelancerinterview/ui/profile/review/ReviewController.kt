package com.jemaystermind.freelancerinterview.ui.profile.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jemaystermind.freelancerinterview.R
import com.jemaystermind.freelancerinterview.ui.ButterKnifeController
import com.jemaystermind.freelancerinterview.ui.inflate

class ReviewController : ButterKnifeController {

  constructor() : super()

  constructor(bundle: Bundle): super(bundle)

  override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View =
      container.inflate(R.layout.controller_profile_review)

  override fun onViewBound(view: View) {

  }
}
