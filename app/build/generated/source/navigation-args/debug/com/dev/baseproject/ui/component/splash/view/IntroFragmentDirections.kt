package com.dev.baseproject.ui.component.splash.view

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.dev.baseproject.NavMainDirections
import com.dev.baseproject.R

public class IntroFragmentDirections private constructor() {
  public companion object {
    public fun atcIntro3ToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.atcIntro3ToHomeFragment)

    public fun actionIntroFragment3ToPermissionFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_introFragment3_to_permissionFragment)

    public fun actionIntroFragment3ToRecordPermissionFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_introFragment3_to_recordPermissionFragment)

    public fun atcOpenMainFragment(): NavDirections = NavMainDirections.atcOpenMainFragment()
  }
}
