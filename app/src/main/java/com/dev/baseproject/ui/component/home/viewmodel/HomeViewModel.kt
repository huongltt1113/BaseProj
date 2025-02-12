package com.dev.baseproject.ui.component.home.viewmodel

import com.dev.baseproject.repository.ScriptRepository
import com.dev.baseproject.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(private val scriptRepository: ScriptRepository) : BaseViewModel() {

    companion object {
        const val TAG = "HomeViewModel"
    }
}