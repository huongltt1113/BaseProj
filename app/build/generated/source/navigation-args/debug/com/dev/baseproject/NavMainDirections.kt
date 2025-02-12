package com.dev.baseproject

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class NavMainDirections private constructor() {
  public companion object {
    public fun atcOpenMainFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.atcOpenMainFragment)
  }
}
