package com.dev.baseproject.ui.component.home.fragment

import androidx.navigation.NavDirections
import com.dev.baseproject.NavMainDirections

public class HowToUseFragmentDirections private constructor() {
  public companion object {
    public fun atcOpenMainFragment(): NavDirections = NavMainDirections.atcOpenMainFragment()
  }
}
