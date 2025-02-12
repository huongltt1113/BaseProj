package com.dev.baseproject.ui.base

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.dev.baseproject.local.LocalStorage
import com.dev.baseproject.utils.AppConfig
import java.lang.reflect.ParameterizedType
import java.util.Locale
import javax.inject.Inject


abstract class BaseActivityBinding<T : ViewDataBinding, V : BaseViewModel> : BaseActivity() {

    open lateinit var dataBinding: T
    open lateinit var viewModel: V
    @Inject
    lateinit var localStorage: LocalStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                window.decorView.layoutDirection = if (AppConfig.isRTL())
                    View.LAYOUT_DIRECTION_RTL
                else
                    View.LAYOUT_DIRECTION_LTR
            }
//            dataBinding = DataBindingUtil.bind(view)!!
            dataBinding = DataBindingUtil.bind(view) ?: throw IllegalStateException("DataBinding failed to bind view")

            dataBinding.lifecycleOwner = this
            @Suppress("UNCHECKED_CAST")
            val clazz: Class<V> =
                (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<V>
            viewModel = ViewModelProvider(this).get(clazz)
        } catch (e: Exception) {
            finish()
            return
        }

        viewModel.toastLiveData.observe(this) {
            if (it is Int) {
                showToast(it)
            } else {
                showToast(it.toString())
            }
        }
        onViewCreated(savedInstanceState)
    }

    open fun onViewCreated(savedInstanceState: Bundle?) {
    }

    override fun onDestroy() {
        if (this::dataBinding.isInitialized)
            dataBinding.unbind()
        super.onDestroy()
    }

    override fun onResume() {
        if (localStorage.langCode.isNotBlank()) {
            val resources: Resources = resources
            val locale = Locale(localStorage.langCode)
            Locale.setDefault(locale)
            val config = Configuration()
            config.setLocale(locale)
            resources.updateConfiguration(config, resources.displayMetrics)
        }
        super.onResume()
    }
//    override fun attachBaseContext(newBase: Context?) {
//        super.attachBaseContext(LocaleHelper().updateResources(newBase!!))
//    }
//
//    override fun onConfigurationChanged(newConfig: Configuration) {
//        super.onConfigurationChanged(newConfig)
//        applyOverrideConfiguration(newConfig)
//    }

    protected val isInitialized get() = this::dataBinding.isInitialized && this::viewModel.isInitialized

}