package com.dev.baseproject.ui.component.home.fragment

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.dev.baseproject.NavMainDirections
import com.dev.baseproject.R
import kotlin.Int

public class HomeFragmentDirections private constructor() {
  private data class ActionHomeFragmentToSoundDetailFragment(
    public val resourceId: Int,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_homeFragment_to_soundDetailFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("resource_id", this.resourceId)
        return result
      }
  }

  private data class ActionHomeFragmentToHowToUseFragment(
    public val mode: Int,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_homeFragment_to_howToUseFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("mode", this.mode)
        return result
      }
  }

  public companion object {
    public fun actionHomeFragmentToCreatePasscodeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_createPasscodeFragment)

    public fun actionHomeFragmentToSoundDetailFragment(resourceId: Int): NavDirections =
        ActionHomeFragmentToSoundDetailFragment(resourceId)

    public fun actionHomeFragmentToSettingFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_settingFragment)

    public fun actionHomeFragmentToHowToUseFragment(mode: Int): NavDirections =
        ActionHomeFragmentToHowToUseFragment(mode)

    public fun actionHomeFragmentToGrantPermissionFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_grantPermissionFragment)

    public fun actionHomeFragmentToChooseSoundFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_chooseSoundFragment)

    public fun actionHomeFragmentToCountDownFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_countDownFragment)

    public fun atcOpenMainFragment(): NavDirections = NavMainDirections.atcOpenMainFragment()
  }
}
