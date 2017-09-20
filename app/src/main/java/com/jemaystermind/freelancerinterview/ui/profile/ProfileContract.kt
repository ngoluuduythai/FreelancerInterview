/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui.profile

import com.jemaystermind.freelancerinterview.ui.BaseMvpView
import com.jemaystermind.freelancerinterview.ui.BasePresenter

object ProfileContract {
  abstract class Presenter : BasePresenter<View>() {
    abstract fun loadProfile(username: String)
  }

  interface View : BaseMvpView {
    fun showProgress(show: Boolean)
  }
}
