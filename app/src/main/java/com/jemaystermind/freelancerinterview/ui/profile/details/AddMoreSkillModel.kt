package com.jemaystermind.freelancerinterview.ui.profile.details

import android.widget.TextView
import butterknife.BindString
import butterknife.BindView
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.jemaystermind.freelancerinterview.R
import com.jemaystermind.freelancerinterview.ui.BaseEpoxyHolder
import com.jemaystermind.freelancerinterview.ui.profile.details.AddMoreSkillModel.ViewHolder

class AddMoreSkillModel(private val currentSkillCount: Int,
    private val maxSkillCount: Int) : EpoxyModelWithHolder<ViewHolder>() {

  init {
    id("add_more_skill_header")
  }

  override fun getDefaultLayout(): Int = R.layout.item_add_more_skill

  override fun createNewHolder(): ViewHolder = ViewHolder()

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
