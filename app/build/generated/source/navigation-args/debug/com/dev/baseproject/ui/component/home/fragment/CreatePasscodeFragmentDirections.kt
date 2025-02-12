package com.dev.baseproject.ui.component.home.fragment

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.dev.baseproject.NavMainDirections
import com.dev.baseproject.R

public class CreatePasscodeFragmentDirections private constructor() {
  public companion object {
    public fun actionCreatePasscodeFragmentToRecordPasscodeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_createPasscodeFragment_to_recordPasscodeFragment)

    public fun actionCreatePasscodeFragmentToTextToVoiceFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_createPasscodeFragment_to_textToVoiceFragment)

    public fun atcOpenMainFragment(): NavDirections = NavMainDirections.atcOpenMainFragment()
  }
}
