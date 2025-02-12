package com.dev.baseproject.ui.component.home.fragment

import android.os.Build
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.dev.baseproject.R
import com.dev.baseproject.databinding.FragmentCreatePasscodeBinding
import com.dev.baseproject.ui.base.BaseFragmentBinding
import com.dev.baseproject.ui.component.home.dialogs.CreatePasscodeDialog
import com.dev.baseproject.utils.AppConfig
import com.dev.baseproject.utils.Constants.GO_TO_RECORD_PASSCODE_AGAIN
import com.dev.baseproject.utils.Constants.GO_TO_RECORD_PASSCODE_FIRST
import com.dev.baseproject.utils.Constants.GO_TO_TEXT_TO_VOICE_AGAIN
import com.dev.baseproject.utils.Constants.GO_TO_TEXT_TO_VOICE_FIRST
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreatePasscodeFragment : BaseFragmentBinding<FragmentCreatePasscodeBinding>() {
    override fun getContentViewId() = R.layout.fragment_create_passcode

    override fun initializeViews() {
        if (localStorage.voicePasscode.isEmpty()){
            dataBinding.llPasscode.visibility = View.GONE
            dataBinding.tvCurrentPasscode.text = ""
            dataBinding.heading.text = context?.resources?.getString(R.string.create_passcode)
        } else {
            dataBinding.llPasscode.visibility = View.VISIBLE
            dataBinding.tvCurrentPasscode.text = localStorage.voicePasscode
            dataBinding.heading.text = context?.resources?.getString(R.string.change_passcode)
        }
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU){
            dataBinding.recordtext.visibility = View.GONE
        }
    }

    override fun registerListeners() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavControllerSafety()?.popBackStack()
            }
        })
        dataBinding.recordpassword.setOnClickListener {
           if(localStorage.goToRecordPasscode){
               AppConfig.logEventTracking(GO_TO_RECORD_PASSCODE_FIRST)
               localStorage.goToRecordPasscode = false
           }else{
               AppConfig.logEventTracking(GO_TO_RECORD_PASSCODE_AGAIN)
           }
           findNavControllerSafety()?.navigate(R.id.action_createPasscodeFragment_to_recordPasscodeFragment)
       }
        dataBinding.recordtext.setOnClickListener {
            if(localStorage.goToRecordPasscode){
                AppConfig.logEventTracking(GO_TO_TEXT_TO_VOICE_FIRST)
                localStorage.goToRecordPasscode = false
            }else{
                AppConfig.logEventTracking(GO_TO_TEXT_TO_VOICE_AGAIN)
            }
            findNavControllerSafety()?.navigate(R.id.action_createPasscodeFragment_to_textToVoiceFragment)
        }

        dataBinding.btnBack.setOnClickListener {
            findNavControllerSafety()?.navigateUp()
        }
}
    override fun initializeData() {

    }

    override fun onResume() {
        super.onResume()
        if(localStorage.isFirstOpenCreatePasscode){
            localStorage.isFirstOpenCreatePasscode = false
            showCreatePasscodeDialog()
        }
    }

    private fun showCreatePasscodeDialog(){
        val dialog = CreatePasscodeDialog()
        dialog.show(parentFragmentManager, "CreatePasscodeDialog")
    }

}
