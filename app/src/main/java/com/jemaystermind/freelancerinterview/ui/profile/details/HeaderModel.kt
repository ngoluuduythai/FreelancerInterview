package com.jemaystermind.freelancerinterview.ui.profile.details

import android.support.annotation.LayoutRes
import android.widget.TextView
import butterknife.BindView
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.jemaystermind.freelancerinterview.R
import com.jemaystermind.freelancerinterview.ui.BaseEpoxyHolder
import com.jemaystermind.freelancerinterview.ui.profile.details.HeaderModel.ViewHolder

class HeaderModel(private val title: String) : EpoxyModelWithHolder<ViewHolder>() {

  init {
    id("header", title)
  }

  @LayoutRes
  override fun getDefaultLayout(): Int = R.layout.item_header_title

  override fun bind(holder: ViewHolder) {
    holder.title.text = title
  }

  override fun createNewHolder(): ViewHolder = ViewHolder()

  class ViewHolder : BaseEpoxyHolder() {
    @BindView(R.id.title)
    lateinit var title: TextView
  }
}
