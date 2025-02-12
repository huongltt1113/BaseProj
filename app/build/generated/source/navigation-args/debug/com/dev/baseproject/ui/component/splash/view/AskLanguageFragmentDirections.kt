package com.dev.baseproject.ui.component.splash.view

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.dev.baseproject.NavMainDirections
import com.dev.baseproject.R

public class AskLanguageFragmentDirections private constructor() {
  public companion object {
    public fun atcAskLanguageToAskLanguage2(): NavDirections =
        ActionOnlyNavDirections(R.id.atcAskLanguageToAskLanguage2)

    public fun atcOpenMainFragment(): NavDirections = NavMainDirections.atcOpenMainFragment()
  }
}
