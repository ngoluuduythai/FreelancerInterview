/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui.profile.details

import android.widget.TextView
import butterknife.BindString
import butterknife.BindView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.jemaystermind.freelancerinterview.R
import com.jemaystermind.freelancerinterview.ui.BaseEpoxyHolder
import com.jemaystermind.freelancerinterview.ui.profile.details.AddMoreSkillModel.ViewHolder

@EpoxyModelClass(layout = R.layout.item_add_more_skill)
abstract class AddMoreSkillModel : EpoxyModelWithHolder<ViewHolder>() {

  @EpoxyAttribute var currentSkillCount: Int = 0
  @EpoxyAttribute var maxSkillCount: Int = 0

  override fun bind(holder: ViewHolder) {
    holder.title.text = String.format(holder.titleText, currentSkillCount, maxSkillCount)
  }

  class ViewHolder : BaseEpoxyHolder() {
    @BindView(R.id.title)
    lateinit var title: TextView

    @BindString(R.string.title_add_more_skills)
    lateinit var titleText: String
  }

}
