package com.dev.baseproject.ui.component.bottomsheet

import android.content.Context
import android.content.DialogInterface
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.dev.baseproject.databinding.BottomSheetConfirmToShowAdsBinding
import com.dev.baseproject.utils.AppConfig
import com.dev.baseproject.utils.Logger
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import java.util.Locale

class ConfirmBottomSheet : BottomSheetDialogFragment() {

    private lateinit var dataBinding: BottomSheetConfirmToShowAdsBinding
    private var myTitle: String = ""
    private var myCcontent: String = ""
    private var myContentOK: String = ""
    var clickConfirmYes: (() -> Unit)? = null
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
        dataBinding = BottomSheetConfirmToShowAdsBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myTitle = arguments?.getString("title").toString()
        myCcontent = arguments?.getString("content").toString()
        myContentOK = arguments?.getString("txtOk").toString()

        dataBinding.txtTitle.text = myTitle
        dataBinding.lytContent.text = myCcontent
        dataBinding.btnConfirmYes.text = myContentOK
        dataBinding.btnConfirmYes.setOnClickListener {
            if (!AppConfig.isDoubleClick()) {
                clickConfirmYes?.invoke()
                dismiss()
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
        dismiss()
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
            Logger.e(e.message)
            Firebase.crashlytics.recordException(e)
        }
    }

    companion object {
        const val TAG = "ConfirmToShowAdsBottomSheet"
        fun newInstance(title : String, content : String, txtOk : String): ConfirmBottomSheet {
            val args = Bundle()
            args.putString("title", title)
            args.putString("content", content)
            args.putString("txtOk", txtOk)
            val fragment = ConfirmBottomSheet()
            fragment.arguments = args
            return fragment
        }
    }
}