package com.dev.baseproject.ui.component.home.fragment

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.dev.baseproject.NavMainDirections
import com.dev.baseproject.R

public class CountDownFragmentDirections private constructor() {
  public companion object {
    public fun actionCountDownFragmentToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_countDownFragment_to_homeFragment)

    public fun atcOpenMainFragment(): NavDirections = NavMainDirections.atcOpenMainFragment()
  }
}
