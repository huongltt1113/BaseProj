package com.dev.baseproject.ads

import com.google.gson.Gson


data class AdModel(val type: AdType, val status: AdStatus, val tag: String) {
    override fun toString(): String {
        return Gson().toJson(this)
    }
}

enum class AdType {
    INTERSTITIAL, REWARD, OPEN, BANNER
}

enum class AdStatus {
    LOADED, CLOSED, OPENED, FAILED_TO_LOAD, EARNED_REWARD, SHOW_FAILED
}
