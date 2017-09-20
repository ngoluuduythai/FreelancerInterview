/*
 * Copyright (c) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */

package com.jemaystermind.freelancerinterview.ui

/**
 * A Presenter that should be extended from for every presenter that handles basic [BaseMvpView]
 * operations.
 *
 * Any presenter could also extend extend from a more generic one [Presenter].
 */
abstract class BasePresenter<V : BaseMvpView> : Presenter<V> {

  var view: V? = null

  override fun attachView(view: V) {
    this.view = view
  }

  override fun detachView() {
    this.view = null
  }

  fun isViewAttached(): Boolean = view != null

  fun checkViewAttached() {
    if (!isViewAttached()) {
      throw IllegalStateException("Presenter.attachView(BaseMvpView) must be called.")
    }
  }
}
