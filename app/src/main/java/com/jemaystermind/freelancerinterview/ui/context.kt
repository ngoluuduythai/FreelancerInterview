package com.jemaystermind.freelancerinterview.ui

import android.content.Context
import android.support.annotation.StringRes
import android.widget.Toast

fun Context.toast(message: String?) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Context.toast(@StringRes message: Int) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
