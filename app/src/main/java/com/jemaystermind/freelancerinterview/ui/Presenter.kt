/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui

interface Presenter<in V : BaseMvpView> {
  fun attachView(view: V)

  fun detachView()
}
