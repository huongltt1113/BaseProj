package com.dev.baseproject.ui.component.splash.view

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.dev.baseproject.NavMainDirections
import com.dev.baseproject.R

public class Directions private constructor() {
  public companion object {
    public fun actionPrivacyTermsFragmentToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_privacyTermsFragment_to_homeFragment)

    public fun atcOpenMainFragment(): NavDirections = NavMainDirections.atcOpenMainFragment()
  }
}
