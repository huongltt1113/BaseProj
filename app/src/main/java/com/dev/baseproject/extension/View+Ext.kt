package com.dev.baseproject.extension

import android.view.View
import android.view.ViewGroup
import com.dev.baseproject.utils.AppConfig.dpToPx

fun View.enable() {
    isEnabled = true
}

fun View.disable() {
    isEnabled = false
}

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.visibleOrGone(visible: Boolean) {
    if (visible) {
        visible()
    } else {
        gone()
    }
}

fun View.visibleOrInvisible(visible: Boolean) {
    if (visible) {
        visible()
    } else {
        invisible()
    }
}


fun View.margin(
    left: Float? = null, top: Float? = null, right: Float? = null, bottom: Float? = null
) {
    layoutParams<ViewGroup.MarginLayoutParams> {
        left?.apply { leftMargin = dpToPx(this) }
        top?.apply { topMargin = dpToPx(this) }
        right?.apply { rightMargin = dpToPx(this) }
        bottom?.apply { bottomMargin = dpToPx(this) }
    }
}

inline fun <reified T : ViewGroup.LayoutParams> View.layoutParams(block: T.() -> Unit) {
    if (layoutParams is T) block(layoutParams as T)
}