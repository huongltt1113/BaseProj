package com.dev.baseproject.ui.component.setting

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.dev.baseproject.R
import com.dev.baseproject.databinding.FragmentSettingBinding
import com.dev.baseproject.ui.base.BaseViewModelFragmentBinding
import com.dev.baseproject.ui.component.splash.viewmodel.SettingViewModel
import com.dev.baseproject.utils.AppConfig
import com.dev.baseproject.utils.Constants
import com.dev.baseproject.utils.Constants.SETTING_FEEDBACK_AGAIN
import com.dev.baseproject.utils.Constants.SETTING_FEEDBACK_FIRST
import com.dev.baseproject.utils.Constants.SETTING_LANGUAGE_AGAIN
import com.dev.baseproject.utils.Constants.SETTING_LANGUAGE_FIRST
import com.dev.baseproject.utils.Constants.SETTING_PRIVACY_AGAIN
import com.dev.baseproject.utils.Constants.SETTING_PRIVACY_FIRST
import com.dev.baseproject.utils.Constants.SETTING_RADIO_CLICK_AGAIN
import com.dev.baseproject.utils.Constants.SETTING_RADIO_CLICK_FIRST
import com.dev.baseproject.utils.Constants.SETTING_RATEUS_AGAIN
import com.dev.baseproject.utils.Constants.SETTING_RATEUS_FIRST
import com.dev.baseproject.utils.Logger
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment : BaseViewModelFragmentBinding<FragmentSettingBinding, SettingViewModel>() {
    override fun getContentViewId() = R.layout.fragment_setting

    override fun initializeViews() {
        if (localStorage.flashSpeed == 1200) {
            dataBinding.radiodefault.isChecked = true
        } else {
            if (localStorage.flashSpeed !== 600) {
                dataBinding.radiosos.isChecked = true
            } else {
                dataBinding.radiodisco.isChecked = true
            }
        }
    }

    override fun registerListeners() {
        dataBinding.btnBack.setOnClickListener {
            findNavControllerSafety()?.navigateUp()
        }
        dataBinding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            if (localStorage.isFirstRadioSettingClick) {
                AppConfig.logEventTracking(SETTING_RADIO_CLICK_FIRST)
                localStorage.isFirstRadioSettingClick = false
            } else {
                AppConfig.logEventTracking(SETTING_RADIO_CLICK_AGAIN)
            }
            localStorage.flashSpeed = 1200
            when (checkedId) {
                R.id.radiodefault -> localStorage.flashSpeed = 1200
                R.id.radiodisco -> localStorage.flashSpeed = 600
                R.id.radiosos -> localStorage.flashSpeed = 300
            }
        }
        dataBinding.rlfeedback.setOnClickListener {
            if (!AppConfig.isDoubleClick()) {
                if (localStorage.isFirstFeedbackSettingClick) {
                    AppConfig.logEventTracking(SETTING_FEEDBACK_FIRST)
                    localStorage.isFirstFeedbackSettingClick = false
                } else {
                    AppConfig.logEventTracking(SETTING_FEEDBACK_AGAIN)
                }
                AppConfig.sendMail(
                    requireContext(), Constants.SUBJECT_EMAIL, requireContext().resources.getString(
                        R.string.choose_email
                    )
                )
            }
        }
        dataBinding.rlrate.setOnClickListener {
            if (!AppConfig.isDoubleClick()) {
                if (localStorage.isFirstRateUsSettingClick) {
                    AppConfig.logEventTracking(SETTING_RATEUS_FIRST)
                    localStorage.isFirstRateUsSettingClick = false
                } else {
                    AppConfig.logEventTracking(SETTING_RATEUS_AGAIN)
                }
                rateUs()
            }
        }
        dataBinding.rlprivacypol.setOnClickListener {
            if (localStorage.isFirstPrivacySettingClick) {
                AppConfig.logEventTracking(SETTING_PRIVACY_FIRST)
                localStorage.isFirstPrivacySettingClick = false
            } else {
                AppConfig.logEventTracking(SETTING_PRIVACY_AGAIN)
            }
            openPrivacyPolicyLink()
        }
        dataBinding.rllang.setOnClickListener {
            if (localStorage.isFirstLanguageSetting) {
                AppConfig.logEventTracking(SETTING_LANGUAGE_FIRST)
                localStorage.isFirstLanguageSetting = false
            } else {
                AppConfig.logEventTracking(SETTING_LANGUAGE_AGAIN)
            }
            try {
                findNavControllerSafety()?.navigate(R.id.act_setting_to_settinglanguage)
            } catch (e: Throwable) {
                Logger.e(e.message)
                Firebase.crashlytics.recordException(e)
            }
        }
    }

    private fun rateUs() {
        val packageName: String = requireContext().packageName
        val intent = Intent("android.intent.action.VIEW")
        intent.setData(Uri.parse("market://details?id=$packageName"))
        try {
            startActivity(intent)
        } catch (unused: Exception) {
            val intent2 = Intent("android.intent.action.VIEW")
            intent2.setData(Uri.parse("https://play.google.com/store/apps/details?id=$packageName"))
            try {
                startActivity(intent2)
            } catch (unused2: Exception) {
                Toast.makeText(
                    requireContext(),
                    "No App to Perform Above Action",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun openPrivacyPolicyLink() {
        val intentPrivacy = Intent(Intent.ACTION_VIEW, Uri.parse(Constants.URL_POLICY))
        intentPrivacy.setPackage("com.android.chrome")
        startActivity(intentPrivacy)
    }

    override fun initializeData() {

    }

}
