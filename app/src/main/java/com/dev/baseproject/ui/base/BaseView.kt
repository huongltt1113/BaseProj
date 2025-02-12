package com.dev.baseproject.ui.base

interface BaseView {
    fun getContentViewId(): Int

    fun initializeViews()

    fun registerListeners()

    fun initializeData()
}