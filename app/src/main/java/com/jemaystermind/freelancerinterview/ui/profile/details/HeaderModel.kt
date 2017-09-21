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
import com.jemaystermind.freelancerinterview.ui.profile.details.HeaderModel.ViewHolder

@EpoxyModelClass(layout = R.layout.item_header_title)
abstract class HeaderModel : EpoxyModelWithHolder<ViewHolder>() {

  @EpoxyAttribute lateinit var title: String

  override fun bind(holder: ViewHolder) {
    holder.title.text = title
  }

  class ViewHolder : BaseEpoxyHolder() {
    @BindView(R.id.title)
    lateinit var title: TextView
  }
}
