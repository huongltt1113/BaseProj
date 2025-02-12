package com.dev.baseproject.ui.component.bottomsheet

import android.content.Context
import android.content.DialogInterface
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.dev.baseproject.R
import com.dev.baseproject.databinding.BottomSheetRatingAppBinding
import com.dev.baseproject.utils.AppConfig
import com.dev.baseproject.utils.Constants
import com.dev.baseproject.utils.Logger
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase

import java.util.Locale

class RatingAppBottomSheet  : BottomSheetDialogFragment() {
    private lateinit var dataBinding: BottomSheetRatingAppBinding
    var clickConfirmYes: ((rate : Int) -> Unit)? = null
    var clickConfirmNo: (() -> Unit)? = null
    var clickConfirmCancel: (() -> Unit)? = null

    override fun show(manager: FragmentManager, tag: String?) {
        try {
            val ft: FragmentTransaction = manager.beginTransaction()
            ft.add(this, tag)
            ft.commitAllowingStateLoss()
        } catch (e: IllegalStateException) {
            Logger.e(TAG, "Exception : $e")
            Firebase.crashlytics.recordException(e)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        dataBinding = BottomSheetRatingAppBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.tvRateUs.setOnClickListener {
            AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_ACTIVITY_RATING_YES)
            when (dataBinding.rating.rating) {
                5f -> {
                    clickConfirmYes?.invoke(5)
                    AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_RATING_5_HOME)
                    context?.let { it1 -> AppConfig.openApp(it1) }
                    dismiss()
                }

                1f -> {
                    clickConfirmYes?.invoke(1)
                    AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_RATING_1_HOME)
                    dismiss()
                }

                2f -> {
                    clickConfirmYes?.invoke(2)
                    AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_RATING_2_HOME)
                    dismiss()
                }

                3f -> {
                    clickConfirmYes?.invoke(3)
                    AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_RATING_3_HOME)
                    dismiss()
                }

                4f -> {
                    clickConfirmYes?.invoke(4)
                    AppConfig.logEventTracking(Constants.BUNDLE_ANALYTICS_RATING_4_HOME)
                    context?.let { it1 -> AppConfig.openApp(it1) }
                    dismiss()
                }

                else -> {
                    Toast.makeText(context, resources.getString(R.string.warning_rating), Toast.LENGTH_SHORT).show()
                }
            }
        }

        dataBinding.btnCancel.setOnClickListener {
            if (!AppConfig.isDoubleClick()) {
                clickConfirmNo?.invoke()
                dismiss()
            }
        }
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        clickConfirmCancel?.invoke()
    }

    fun updateLanguage(context : Context?, language: String) {
        try {
            if (language.isNotBlank()) {
                val resources: Resources? = context?.resources
                val locale = Locale(language)
                Locale.setDefault(locale)
                val config = Configuration()
                config.locale = locale
                resources?.updateConfiguration(config, resources?.displayMetrics)
            }
        } catch (e : Exception) {
            Logger.e(TAG, "Exception : $e")
            Firebase.crashlytics.recordException(e)
        }
    }

    companion object {
        const val TAG = "RatingAppBottomSheet"
    }
}