/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui.profile.details

import android.widget.TextView
import butterknife.BindView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.jemaystermind.freelancerinterview.R
import com.jemaystermind.freelancerinterview.ui.BaseEpoxyHolder
import com.jemaystermind.freelancerinterview.ui.profile.details.AboutDetailsModel.ViewHolder

@EpoxyModelClass(layout = R.layout.item_about_details)
abstract class AboutDetailsModel : EpoxyModelWithHolder<ViewHolder>() {

  @EpoxyAttribute lateinit var details: String

  override fun bind(holder: ViewHolder) {
    holder.details.text = details
  }

  class ViewHolder : BaseEpoxyHolder() {
    @BindView(R.id.summary)
    lateinit var details: TextView
  }
}
