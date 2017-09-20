package com.jemaystermind.freelancerinterview.ui.profile.details

import android.support.annotation.LayoutRes
import android.widget.TextView
import butterknife.BindView
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.jemaystermind.freelancerinterview.R
import com.jemaystermind.freelancerinterview.ui.BaseEpoxyHolder
import com.jemaystermind.freelancerinterview.ui.profile.details.AboutDetailsModel.ViewHolder

class AboutDetailsModel(private val details: String) : EpoxyModelWithHolder<ViewHolder>() {

  init {
    id("about_details", details.length.toLong())
  }

  @LayoutRes
  override fun getDefaultLayout(): Int = R.layout.item_about_details

  override fun createNewHolder(): ViewHolder = ViewHolder()

  override fun bind(holder: ViewHolder) {
    holder.details.text = details
  }

  class ViewHolder : BaseEpoxyHolder() {
    @BindView(R.id.details)
    lateinit var details: TextView
  }
}
