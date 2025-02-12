package com.dev.baseproject.ui.component.permission

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.dev.baseproject.NavMainDirections
import com.dev.baseproject.R

public class PermissionFragmentDirections private constructor() {
  public companion object {
    public fun actionBatteryPermissionFragmentToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_batteryPermissionFragment_to_homeFragment)

    public fun atcOpenMainFragment(): NavDirections = NavMainDirections.atcOpenMainFragment()
  }
}
