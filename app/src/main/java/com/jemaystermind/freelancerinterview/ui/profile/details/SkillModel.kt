/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui.profile.details

import android.widget.CheckBox
import butterknife.BindView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.jemaystermind.freelancerinterview.R
import com.jemaystermind.freelancerinterview.ui.BaseEpoxyHolder
import com.jemaystermind.freelancerinterview.ui.profile.details.SkillModel.ViewHolder

@EpoxyModelClass(layout = R.layout.item_skill)
abstract class SkillModel : EpoxyModelWithHolder<ViewHolder>() {

  @EpoxyAttribute lateinit var skill: SkillViewModel

  override fun bind(holder: ViewHolder) {
    holder.skill.isChecked = skill.checked
    holder.skill.text = skill.title
  }

  class ViewHolder : BaseEpoxyHolder() {
    @BindView(R.id.skill)
    lateinit var skill: CheckBox
  }
}
