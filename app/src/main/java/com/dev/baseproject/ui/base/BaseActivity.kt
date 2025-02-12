package com.dev.baseproject.ui.base

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.dev.baseproject.R
import com.dev.baseproject.utils.Logger
import com.google.gson.internal.Primitives
import com.dev.baseproject.data.AppDatabase
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseActivity : BaseView, AppCompatActivity(), NavigationCallback {

    protected lateinit var view: View
    @Inject
    lateinit var database: AppDatabase

    private val mHandler = Handler(Looper.getMainLooper())
    open var delayMillis = 600L
    private var isLoading = false
    private lateinit var mNavigation: NavigationControllerImp
    val navigation: NavigationController get() = mNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        mNavigation = NavigationControllerImp(supportFragmentManager)
        mNavigation.callback = this
        super.onCreate(savedInstanceState)
//        view = layoutInflater.inflate(getContentViewId(), null)
//        setContentView(view)
        val binding = DataBindingUtil.setContentView<ViewDataBinding>(this, getContentViewId())
        view = binding.root
        init(view)
    }

    open fun init(view: View) {

    }

    fun setStatusBarColor(color: Int) {
        window.statusBarColor = color
    }

    var isTransparentStatusBar: Boolean
        set(value) {
            window.statusBarColor = if (value) Color.TRANSPARENT else ContextCompat.getColor(
                this,
                R.color.colorSecondary
            )
        }
        get() = window.statusBarColor == Color.TRANSPARENT


    open fun setTransparentNavigationBar(on: Boolean) {
        setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, on)
        window.navigationBarColor = if (on) Color.TRANSPARENT else Color.BLACK
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorSecondary)
    }

    open fun setWindowFlag(bits: Int, on: Boolean) {
        val winParams = window.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        window.attributes = winParams
    }

    open fun popToRoot(animate: Boolean = true) {
        val first = mNavigation.peek
        var last = mNavigation.peek
        while (last != null) {
            mNavigation.popFragment(tag = last, animate = false)
            last = mNavigation.peek
        }
        mNavigation.popFragment(tag = first, animate = animate)
    }

    override fun finish() {
//  overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        super.finish()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments[0].childFragmentManager.fragments.forEach {
            if (it is BaseFragment && it.onBackPressed()) {
                return
            }
        }
        if (shouldOverrideBackPressed()) {
            super.onBackPressed()
        }
    }


    inline fun <reified T : Fragment> findFragment(): T? {
        return supportFragmentManager.fragments.lastOrNull { it as? T != null } as? T
    }

    open fun <T : Fragment> findFragment(clazz: KClass<T>, tag: String? = null): T? {
        try {
            val name = tag ?: clazz.java.name
            val fg = supportFragmentManager.findFragmentByTag(name)
            if (fg != null) {
                return Primitives.wrap(clazz.java).cast(fg)
            }
        } catch (e: Exception) {

        }
        return null
    }

    open fun shouldOverrideBackPressed(): Boolean {
        return true
    }
//
//    open fun onBackPressedFragment() : Boolean {
//        return true
//    }

    override fun onDestroy() {
        mHandler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }

    fun showToast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

    fun showToast(@StringRes id: Int) {
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show()
    }

    fun showLongToast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }

    fun showLongToast(@StringRes id: Int) {
        Toast.makeText(this, id, Toast.LENGTH_LONG).show()
    }

    open fun handleResponse(code: Int, cause: Any?) {
        Logger.d("Error status = " + code + " ; cause = " + cause?.toString())
    }

    open fun didClickConfirmNetwork() {

    }

    override fun prepareToPushFragment() {
        topFragment?.let {
            it.childFragmentManager.fragments.forEach { child ->
                (child as? BaseFragment)?.prepareToPushFragment()
            }
            it.prepareToPushFragment()
        }
    }

    val topFragment: BaseFragment?
        get() {
            var tf = navigation.topFragment as? BaseFragment
            while (tf != null) {
                val fg = tf.navigation?.topFragment as? BaseFragment
                if (fg == null) return tf
                else tf = fg
            }
            return tf
        }

    override fun didPushFragment(fragment: Fragment) {
        topFragment?.let {
            it.childFragmentManager.fragments.forEach { child ->
                (child as? BaseFragment)?.didPushFragment(fragment)
            }
            it.didPushFragment(fragment)
        }
    }

    override fun didRemoveFragment(fragment: Fragment) {
        topFragment?.let {
            it.childFragmentManager.fragments.forEach { child ->
                (child as? BaseFragment)?.didRemoveFragment(fragment)
            }
            it.didRemoveFragment(fragment)
        }
    }

    open fun onBackPressedLoading() {
        (navigation.topFragment as? BaseFragment)?.onBackPressedLoading()
    }

    fun hiddenKeyboard() {
        var viewFocus = view.findFocus()
        if (viewFocus == null) {
            viewFocus = findViewById(android.R.id.content) ?: return
        }

        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(viewFocus.windowToken, 0)
        viewFocus.clearFocus()
    }

    fun showKeyboard(view: View? = null) {
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val v = view ?: this.currentFocus as? EditText
        if (v != null) {
            inputMethodManager.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT)
        } else {
            inputMethodManager.toggleSoftInput(
                InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY
            )
        }
    }

    //endregion

    fun post(runnable: Runnable) {
        if (isFinishing || isDestroyed) return
        mHandler.post(runnable)
    }

    fun post(runnable: (() -> Unit)) {
        if (isFinishing || isDestroyed) return
        mHandler.post(runnable)
    }

    fun postDelayed(runnable: Runnable, delayMillis: Long) {
        if (isFinishing || isDestroyed) return
        mHandler.postDelayed(runnable, delayMillis)
    }

    fun removeCallbacks(runnable: Runnable) {
        mHandler.removeCallbacks(runnable)
    }

    val allFragments: List<BaseFragment> get() = supportFragmentManager.fragments.mapNotNull { it as? BaseFragment }
}
