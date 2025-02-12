package com.dev.baseproject.extension

import android.view.View
import android.view.ViewGroup

fun View.disable() {
    isEnabled = false
}

fun View.gone() {
    visibility = View.GONE
}

inline fun <reified T : ViewGroup.LayoutParams> View.layoutParams(block: T.() -> Unit) {
    if (layoutParams is T) block(layoutParams as T)
}