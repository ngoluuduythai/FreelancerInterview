package com.jemaystermind.freelancerinterview.ui

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)

fun View.show() {
  visibility = View.VISIBLE
}

fun View.hide() {
  visibility = View.GONE
}

fun View.toggle(visible: Boolean) {
  if (visible) {
    show()
  } else {
    hide()
  }
}

fun View.enable() {
  isEnabled = true
}

fun View.disable() {
  isEnabled = false
}
