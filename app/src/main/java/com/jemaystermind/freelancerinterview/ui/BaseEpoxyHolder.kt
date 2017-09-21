/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui

import android.support.annotation.CallSuper
import android.view.View
import butterknife.ButterKnife
import com.airbnb.epoxy.EpoxyHolder

abstract class BaseEpoxyHolder : EpoxyHolder(){
  @CallSuper
  override fun bindView(view: View) {
    ButterKnife.bind(this, view)
  }
}
