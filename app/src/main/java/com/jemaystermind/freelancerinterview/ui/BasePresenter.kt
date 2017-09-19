/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui

abstract class BasePresenter<V : MvpView>(var view: V? = null) : Presenter<V> {
  override fun attachView(view: V) {
    this.view = view
  }

  override fun detachView() {
    this.view = null
  }

  fun isViewAttached(): Boolean = view != null

  fun checkViewAttached() {
    if (!isViewAttached()) {
      throw IllegalStateException("Presenter not initialized. Presenter.attachView(MvpView) " +
          "must be called.")
    }
  }
}
