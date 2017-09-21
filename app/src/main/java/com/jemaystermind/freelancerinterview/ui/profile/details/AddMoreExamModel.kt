package com.jemaystermind.freelancerinterview.ui.profile.details

import android.view.View
import android.widget.TextView
import butterknife.BindString
import butterknife.BindView
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.jemaystermind.freelancerinterview.R
import com.jemaystermind.freelancerinterview.R.id
import com.jemaystermind.freelancerinterview.ui.BaseEpoxyHolder
import com.jemaystermind.freelancerinterview.ui.profile.details.AddMoreExamModel.ViewHolder

@EpoxyModelClass(layout = R.layout.item_add_more_class)
abstract class AddMoreExamModel : EpoxyModelWithHolder<ViewHolder>() {

  override fun getDefaultLayout(): Int = R.layout.item_add_more_class

  override fun createNewHolder(): ViewHolder = ViewHolder()

  class ViewHolder : BaseEpoxyHolder() {
    @BindView(id.title)
    lateinit var title: TextView

    @BindString(R.string.title_add_more_class)
    lateinit var titleText: String

    override fun bindView(view: View) {
      super.bindView(view)
      title.text = titleText
    }
  }
}
