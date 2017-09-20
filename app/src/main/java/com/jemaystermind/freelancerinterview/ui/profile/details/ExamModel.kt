package com.jemaystermind.freelancerinterview.ui.profile.details

import android.support.annotation.LayoutRes
import android.widget.CheckBox
import android.widget.ProgressBar
import butterknife.BindView
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.jemaystermind.freelancerinterview.R
import com.jemaystermind.freelancerinterview.ui.BaseEpoxyHolder
import com.jemaystermind.freelancerinterview.ui.profile.details.ExamModel.ViewHolder

class ExamModel(val data: ExamViewModel) : EpoxyModelWithHolder<ViewHolder>() {

  init {
    id("exam", data.title + data.progress)
  }

  @LayoutRes
  override fun getDefaultLayout(): Int = R.layout.item_exam

  override fun createNewHolder(): ViewHolder = ViewHolder()

  override fun bind(holder: ViewHolder) {
    holder.exam.isChecked = data.checked
    holder.exam.text = data.title
    holder.examProgress.progress = data.progress
  }

  class ViewHolder : BaseEpoxyHolder() {
    @BindView(R.id.exam)
    lateinit var exam: CheckBox

    @BindView(R.id.exam_progress)
    lateinit var examProgress: ProgressBar
  }
}
