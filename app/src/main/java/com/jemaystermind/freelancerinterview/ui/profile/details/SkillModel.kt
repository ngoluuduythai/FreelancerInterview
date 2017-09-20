package com.jemaystermind.freelancerinterview.ui.profile.details

import android.support.annotation.LayoutRes
import android.widget.CheckBox
import butterknife.BindView
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.jemaystermind.freelancerinterview.R
import com.jemaystermind.freelancerinterview.ui.BaseEpoxyHolder
import com.jemaystermind.freelancerinterview.ui.profile.details.SkillModel.ViewHolder

class SkillModel(private val data: SkillViewModel) : EpoxyModelWithHolder<ViewHolder>() {

  init {
    id("skill", data.title)
  }

  @LayoutRes
  override fun getDefaultLayout(): Int = R.layout.item_skill

  override fun createNewHolder(): ViewHolder = ViewHolder()

  override fun bind(holder: ViewHolder) {
    holder.skill.isChecked = data.checked
    holder.skill.text = data.title
  }

  class ViewHolder : BaseEpoxyHolder() {
    @BindView(R.id.skill)
    lateinit var skill: CheckBox
  }
}
