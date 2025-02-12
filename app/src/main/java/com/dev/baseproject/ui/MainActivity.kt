package com.dev.baseproject.ui

import android.os.Bundle
import com.dev.baseproject.R
import com.dev.baseproject.databinding.ActivityMainBinding
import com.dev.baseproject.ui.base.BaseActivityBinding
import com.dev.baseproject.utils.AppConfig
import com.dev.baseproject.utils.Logger
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivityBinding<ActivityMainBinding, MainViewModel>() {

    override fun getContentViewId() = R.layout.activity_main

    override fun initializeViews() {
        Logger.d("initialize MainActivity")
    }

    override fun registerListeners() {
    }

    override fun initializeData() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppConfig.updateResources(this, localStorage.langCode)
    }

}
