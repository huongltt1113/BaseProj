package com.dev.baseproject.ui.base

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.dev.baseproject.extension.popFragment
import com.dev.baseproject.utils.Logger
import java.lang.reflect.ParameterizedType

abstract class BaseViewModelFragmentBinding<T : ViewDataBinding, V : BaseViewModel> :
    BaseFragment() {

    open lateinit var dataBinding: T
    open lateinit var viewModel: V

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            dataBinding = DataBindingUtil.bind(view)!!
            dataBinding.lifecycleOwner = this
            @Suppress("UNCHECKED_CAST")
            val clazz: Class<V> =
                (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<V>
            viewModel = ViewModelProvider(this).get(clazz)
        } catch (e: Exception) {
            Logger.e(e)
            popFragment()
            return
        }
        if (isInitialized) {
            super.onViewCreated(view, savedInstanceState)
            setupObserver(viewModel)
        }
    }

    protected val isInitialized get() = this::viewModel.isInitialized && this::dataBinding.isInitialized

}