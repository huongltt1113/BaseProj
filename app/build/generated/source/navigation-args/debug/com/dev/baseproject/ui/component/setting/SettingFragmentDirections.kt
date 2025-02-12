package com.dev.baseproject.ui.component.setting

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.dev.baseproject.NavMainDirections
import com.dev.baseproject.R

public class SettingFragmentDirections private constructor() {
  public companion object {
    public fun actSettingToSettinglanguage(): NavDirections =
        ActionOnlyNavDirections(R.id.act_setting_to_settinglanguage)

    public fun atcOpenMainFragment(): NavDirections = NavMainDirections.atcOpenMainFragment()
  }
}
