package com.jemaystermind.freelancerinterview.ui.profile.review

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jemaystermind.freelancerinterview.R
import com.jemaystermind.freelancerinterview.ui.ButterKnifeController
import com.jemaystermind.freelancerinterview.ui.inflate
import kotlinx.android.synthetic.main.controller_profile_review.view.recyler

class ReviewController : ButterKnifeController {

  constructor() : super()

  constructor(bundle: Bundle) : super(bundle)

  override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View =
      container.inflate(R.layout.controller_profile_review)

  override fun onViewBound(view: View) {
    view.recyler.layoutManager = LinearLayoutManager(activity)
  }
}
