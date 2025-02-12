package com.dev.baseproject.extension

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.dev.baseproject.R
import com.dev.baseproject.ui.base.BaseActivity
import com.dev.baseproject.ui.base.NavigationController
import kotlin.reflect.KClass

fun Fragment.pushFragment(
    fragment: Fragment,
    bundle: Bundle? = null,
    tag: String? = null,
    animate: Boolean = true,
    viewId: Int = 0,
    singleton: Boolean = false
) {
    val activity = activity as? BaseActivity ?: return
    activity.navigation.pushFragment(
        fragment = fragment,
        bundle = bundle,
        tag = tag,
        animate = animate,
        viewId = viewId,
        singleton = singleton,
        parentTag = arguments?.getString(NavigationController.FRAGMENT_NAME_TAG)
    )
}

fun Fragment.pushFragment(
    clazz: KClass<out Fragment>,
    bundle: Bundle? = null,
    tag: String? = null,
    animate: Boolean = true,
    singleton: Boolean = false
) {
    val activity = activity as? BaseActivity ?: return
    activity.navigation.pushFragment(
        clazz = clazz, bundle = bundle, tag = tag, animate = animate, singleton = singleton
    )
}

fun Fragment.replaceFragment(viewId: Int, fragment: Fragment) {
    val activity = activity as? BaseActivity ?: return
    activity.navigation.replaceFragment(viewId, fragment)
}

fun Fragment.popFragment(clazz: KClass<out Fragment>? = null, animate: Boolean = false): Boolean {
    val activity = activity as? BaseActivity ?: return false
    if (clazz == null) {
        return activity.navigation.popFragment(this, animate)
    }
    return activity.navigation.popFragment(clazz = clazz, animate = animate)
}

fun Fragment.popFragment2(
    fragment: Fragment? = null,
    clazz: KClass<out Fragment>? = null,
    tag: String? = null,
    animateRightOrLeft: Boolean = false
): Boolean {
    val activity = activity as? BaseActivity ?: return false
    if (fragment == null && clazz == null && tag == null) {
        return activity.navigation.popFragment2(this, animateRightOrLeft = animateRightOrLeft)
    }
    return activity.navigation.popFragment2(
        fragment = fragment, clazz = clazz, tag = tag, animateRightOrLeft = animateRightOrLeft
    )
}

fun Fragment.popToRoot(animate: Boolean = true) {
    val activity = activity as? BaseActivity ?: return
    return activity.navigation.popToRoot(animate = animate)
}

fun Fragment.removeFragment(clazz: KClass<out Fragment>? = null, tag: String? = null) {
    val activity = activity as? BaseActivity ?: return
    when {
        clazz != null -> {
            activity.navigation.removeFragment(clazz)
        }

        tag != null -> {
            activity.navigation.removeFragment(tag)
        }

        else -> {
            activity.navigation.removeFragment(this)
        }
    }
}

fun <T : Fragment> Fragment.findFragment(clazz: KClass<T>, tag: String? = null): T? {
    return (activity as? BaseActivity)?.run { navigation.findFragment(clazz, tag) }
}

fun Fragment.transitionInLeft() {
    val con = context
    if (con != null) {
        val anim = AnimationUtils.loadAnimation(con, R.anim.slide_in_left)
        view?.startAnimation(anim)
    }
}

fun Fragment.transitionOutLeft() {
    val con = context
    if (con != null) {
        val anim = AnimationUtils.loadAnimation(con, R.anim.slide_out_left)
        view?.startAnimation(anim)
    }
}
