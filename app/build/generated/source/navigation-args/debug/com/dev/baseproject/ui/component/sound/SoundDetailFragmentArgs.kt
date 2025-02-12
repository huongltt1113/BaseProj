package com.dev.baseproject.ui.component.sound

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class SoundDetailFragmentArgs(
  public val resourceId: Int,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("resource_id", this.resourceId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("resource_id", this.resourceId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): SoundDetailFragmentArgs {
      bundle.setClassLoader(SoundDetailFragmentArgs::class.java.classLoader)
      val __resourceId : Int
      if (bundle.containsKey("resource_id")) {
        __resourceId = bundle.getInt("resource_id")
      } else {
        throw IllegalArgumentException("Required argument \"resource_id\" is missing and does not have an android:defaultValue")
      }
      return SoundDetailFragmentArgs(__resourceId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): SoundDetailFragmentArgs {
      val __resourceId : Int?
      if (savedStateHandle.contains("resource_id")) {
        __resourceId = savedStateHandle["resource_id"]
        if (__resourceId == null) {
          throw IllegalArgumentException("Argument \"resource_id\" of type integer does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"resource_id\" is missing and does not have an android:defaultValue")
      }
      return SoundDetailFragmentArgs(__resourceId)
    }
  }
}
