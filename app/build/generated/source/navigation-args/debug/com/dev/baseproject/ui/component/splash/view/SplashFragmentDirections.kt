package com.dev.baseproject.ui.component.splash.view

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.dev.baseproject.NavMainDirections
import com.dev.baseproject.R

public class SplashFragmentDirections private constructor() {
  public companion object {
    public fun actionSplashFragmentToPrivacyTermsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_splashFragment_to_privacyTermsFragment)

    public fun actionSplashtoAskLanguageFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.actionSplashtoAskLanguageFragment)

    public fun actionSplashtoHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.actionSplashtoHomeFragment)

    public fun atcOpenMainFragment(): NavDirections = NavMainDirections.atcOpenMainFragment()
  }
}
