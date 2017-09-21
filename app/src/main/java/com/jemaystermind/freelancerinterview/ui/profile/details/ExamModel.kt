/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui.profile.details

import android.widget.CheckBox
import android.widget.ProgressBar
import butterknife.BindView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.jemaystermind.freelancerinterview.R
import com.jemaystermind.freelancerinterview.ui.BaseEpoxyHolder
import com.jemaystermind.freelancerinterview.ui.profile.details.ExamModel.ViewHolder

@EpoxyModelClass(layout = R.layout.item_exam)
abstract class ExamModel : EpoxyModelWithHolder<ViewHolder>() {

  @EpoxyAttribute lateinit var exam: ExamViewModel

  override fun bind(holder: ViewHolder) {
    holder.exam.isChecked = exam.checked
    holder.exam.text = exam.title
    holder.examProgress.progress = exam.progress
  }

  class ViewHolder : BaseEpoxyHolder() {
    @BindView(R.id.exam)
    lateinit var exam: CheckBox

    @BindView(R.id.exam_progress)
    lateinit var examProgress: ProgressBar
  }
}
