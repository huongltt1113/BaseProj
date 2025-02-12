package com.dev.baseproject.ui.component.sound

import android.os.Bundle
import androidx.navigation.NavDirections
import com.dev.baseproject.NavMainDirections
import com.dev.baseproject.R
import kotlin.Int

public class ChooseSoundFragmentDirections private constructor() {
  private data class ActionChooseSoundFragmentToSoundDetailFragment(
    public val resourceId: Int,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_chooseSoundFragment_to_soundDetailFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("resource_id", this.resourceId)
        return result
      }
  }

  public companion object {
    public fun actionChooseSoundFragmentToSoundDetailFragment(resourceId: Int): NavDirections =
        ActionChooseSoundFragmentToSoundDetailFragment(resourceId)

    public fun atcOpenMainFragment(): NavDirections = NavMainDirections.atcOpenMainFragment()
  }
}
