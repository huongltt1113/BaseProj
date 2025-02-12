package com.dev.baseproject.ui.component.home.fragment

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class HowToUseFragmentArgs(
  public val mode: Int,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("mode", this.mode)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("mode", this.mode)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): HowToUseFragmentArgs {
      bundle.setClassLoader(HowToUseFragmentArgs::class.java.classLoader)
      val __mode : Int
      if (bundle.containsKey("mode")) {
        __mode = bundle.getInt("mode")
      } else {
        throw IllegalArgumentException("Required argument \"mode\" is missing and does not have an android:defaultValue")
      }
      return HowToUseFragmentArgs(__mode)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): HowToUseFragmentArgs {
      val __mode : Int?
      if (savedStateHandle.contains("mode")) {
        __mode = savedStateHandle["mode"]
        if (__mode == null) {
          throw IllegalArgumentException("Argument \"mode\" of type integer does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"mode\" is missing and does not have an android:defaultValue")
      }
      return HowToUseFragmentArgs(__mode)
    }
  }
}
