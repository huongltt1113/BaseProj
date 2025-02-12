package com.dev.baseproject.ui.component.splash.view

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import com.dev.baseproject.R
import com.dev.baseproject.databinding.FragmentIntroBinding
import com.dev.baseproject.ui.MainActivity
import com.dev.baseproject.ui.base.BaseViewModelFragmentBinding
import com.dev.baseproject.ui.component.permission.PermissionFragment.Companion.KEY_RECORD_PERMISSION
import com.dev.baseproject.ui.component.splash.viewmodel.TopicViewModel
import com.dev.baseproject.utils.AppConfig
import com.dev.baseproject.utils.Constants
import com.dev.baseproject.utils.OnSwipeTouchListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IntroFragment : BaseViewModelFragmentBinding<FragmentIntroBinding, TopicViewModel>() {

    private var isIntro2 = false
    private var isIntro3 = false
    override fun getContentViewId() = R.layout.fragment_intro

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).checkShowRequestInternet()
    }

    override fun initializeViews() {
        isIntro2 = arguments?.containsKey(KEY_INTRO2) ?: false
        isIntro3 = arguments?.containsKey(KEY_INTRO3) ?: false

        if (isIntro2) {
            dataBinding.ivIndicator.setImageResource(R.drawable.progress_indicators_2)
            dataBinding.imgIntro.setImageResource(R.drawable.intro_2)
            dataBinding.txtTitle.text = getString(R.string.text_intro2_title)
            dataBinding.txtMsg.text = getString(R.string.text_intro2_msg)

            if (localStorage.isFirstOpenIntro2) {
                AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_GO_TO_INTRO_2_FIRST)
                localStorage.isFirstOpenIntro2 = false
            } else {
                AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_GO_TO_INTRO_2_AGAIN)
            }
            return
        } else if (isIntro3) {
            dataBinding.ivIndicator.setImageResource(R.drawable.progress_indicators_3)
            dataBinding.imgIntro.setImageResource(R.drawable.intro_3)
            dataBinding.txtTitle.text = getString(R.string.text_intro3_title)
            dataBinding.txtMsg.text = getString(R.string.text_intro3_msg)
            dataBinding.txtNext.text = getString(R.string.get_started)
            if (localStorage.isFirstOpenIntro3) {
                AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_GO_TO_INTRO_3_FIRST)
                localStorage.isFirstOpenIntro3 = false
            } else {
                AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_GO_TO_INTRO_3_AGAIN)
            }
            return
        } else {
            dataBinding.ivIndicator.setImageResource(R.drawable.progress_indicators_1)
            dataBinding.imgIntro.setImageResource(R.drawable.intro_1)
            dataBinding.txtTitle.text = getString(R.string.text_intro1_title)
            dataBinding.txtMsg.text = getString(R.string.text_intro1_msg)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun registerListeners() {
        dataBinding.rootLayout.setOnTouchListener(object: OnSwipeTouchListener(requireContext()){
            override fun onSwipeRight() {
                findNavControllerSafety()?.navigateUp()
            }

            override fun onSwipeLeft() {
                if(isIntro2){
                    val bundle = Bundle()
                    bundle.putBoolean(KEY_INTRO3, true)
                    try {
                        findNavControllerSafety()?.navigate(R.id.atcOpenNext, bundle)
                    } catch (ex : Exception) {

                    }
                } else if(isIntro3){
                    if(Build.VERSION.SDK_INT >= 33){
                        findNavControllerSafety()?.navigate(R.id.action_introFragment3_to_permissionFragment)
                    } else {
                        val bundle = Bundle()
                        bundle.putBoolean(KEY_RECORD_PERMISSION, true)
                        findNavControllerSafety()?.navigate(R.id.action_introFragment3_to_recordPermissionFragment, bundle)
                    }                } else {
                    val bundle = Bundle()
                    bundle.putBoolean(KEY_INTRO2, true)
                    try {
                        findNavControllerSafety()?.navigate(R.id.actOpenIntro2, bundle)
                    } catch (ex : Exception) {

                    }
                }
            }
        })
        dataBinding.txtNext.setOnClickListener {
            if (isIntro2) {
                val bundle = Bundle()
                bundle.putBoolean(KEY_INTRO3, true)
                try {
                    findNavControllerSafety()?.navigate(R.id.atcOpenNext, bundle)
                } catch (ex : Exception) {

                }
            } else if (isIntro3){
                try {
                    if(Build.VERSION.SDK_INT >= 33){
                        findNavControllerSafety()?.navigate(R.id.action_introFragment3_to_permissionFragment)
                    } else {
                        val bundle = Bundle()
                        bundle.putBoolean(KEY_RECORD_PERMISSION, true)
                        findNavControllerSafety()?.navigate(R.id.action_introFragment3_to_recordPermissionFragment, bundle)
                    }
                } catch (ex : Exception) {

                }
            } else {
                val bundle = Bundle()
                bundle.putBoolean(KEY_INTRO2, true)
                try {
                    findNavControllerSafety()?.navigate(R.id.actOpenIntro2, bundle)
                } catch (ex : Exception) {

                }
            }
        }
    }

    override fun initializeData() {
    }

    companion object {
        const val KEY_INTRO1 = "isIntro1"
        const val KEY_INTRO2 = "isIntro2"
        const val KEY_INTRO3 = "isIntro3"
    }
}