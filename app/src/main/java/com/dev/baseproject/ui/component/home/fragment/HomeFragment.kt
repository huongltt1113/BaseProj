package com.dev.baseproject.ui.component.home.fragment

import com.dev.baseproject.R
import com.dev.baseproject.databinding.FragmentHomeBinding
import com.dev.baseproject.ui.base.BaseViewModelFragmentBinding
import com.dev.baseproject.ui.component.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseViewModelFragmentBinding<FragmentHomeBinding, HomeViewModel>() {

    override fun getContentViewId() = R.layout.fragment_home

    override fun initializeViews() {}

    override fun registerListeners() {
        dataBinding.settings.setOnClickListener {
            findNavControllerSafety()?.navigate(R.id.action_homeFragment_to_settingFragment)
        }
    }

    override fun initializeData() {
    }
}
