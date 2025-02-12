package com.dev.baseproject.ui.component.splash.view

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.dev.baseproject.NavMainDirections
import com.dev.baseproject.R

public class AskLanguageFragment2Directions private constructor() {
  public companion object {
    public fun atcAskLanguage2ToIntroFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.atcAskLanguage2ToIntroFragment)

    public fun actAskLanguage2ToIntroFragment1(): NavDirections =
        ActionOnlyNavDirections(R.id.actAskLanguage2ToIntroFragment1)

    public fun atcOpenMainFragment(): NavDirections = NavMainDirections.atcOpenMainFragment()
  }
}
