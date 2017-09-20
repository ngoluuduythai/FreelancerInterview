package com.jemaystermind.freelancerinterview.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import com.bluelinelabs.conductor.Controller

abstract class ButterKnifeController : Controller {

  private lateinit var unbinder: Unbinder

  constructor() : super()

  constructor(args: Bundle) : super(args)

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
    val view = inflateView(inflater, container)
    unbinder = ButterKnife.bind(this, view)
    onViewBound(view)
    return view
  }

  protected abstract fun inflateView(inflater: LayoutInflater, container: ViewGroup): View

  abstract fun onViewBound(view: View)

  override fun onDestroyView(view: View) {
    super.onDestroyView(view)
    unbinder.unbind()
  }
}
