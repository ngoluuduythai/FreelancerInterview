package com.jemaystermind.freelancerinterview.ui

import android.os.Bundle
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.jemaystermind.freelancerinterview.R
import com.jemaystermind.freelancerinterview.data.User
import com.jemaystermind.freelancerinterview.ui.profile.ProfileController
import kotlinx.android.synthetic.main.activity_main.controller_container
import javax.inject.Inject

class MainActivity : BaseActivity() {

  lateinit var controllerComponent: ControllerComponent

  @Inject
  lateinit var router: Router

  @Inject
  lateinit var user: User

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val userComponent = app.userComponent ?: throw IllegalStateException("No user found")

    controllerComponent = userComponent.plus(ControllerModule(this, controller_container, savedInstanceState))
    controllerComponent.inject(this)

    if (!router.hasRootController()) {
      router.setRoot(RouterTransaction.with(ProfileController(user.username)))
    }
  }

  override fun onBackPressed() {
    if (!router.handleBack()) {
      super.onBackPressed()
    }
  }
}
