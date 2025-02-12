package com.dev.baseproject.extension

import android.graphics.Typeface
import android.os.Build
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.text.HtmlCompat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.dev.baseproject.utils.Constants
import java.io.UnsupportedEncodingException
import java.net.URLEncoder
import java.security.MessageDigest
import kotlin.experimental.and

fun String.urlEncoder(): String {
    return try {
        URLEncoder.encode(this, "UTF-8").replace("+", "%20")
    } catch (e: UnsupportedEncodingException) {
        this
    }
}

inline fun <reified T> fromJson(json: String): T {
    return Gson().fromJson(json, object : TypeToken<T>() {}.type)
}

val String.fromHtml: Spanned
    get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(this, HtmlCompat.FROM_HTML_MODE_LEGACY)
    } else {
        @Suppress("DEPRECATION") Html.fromHtml(this)
    }

fun String.fromHex(): String {
    val str = StringBuilder()
    var i = 0
    while (i < length) {
        str.append(substring(i, i + 2).toInt(16).toChar())
        i += 2
    }
    return str.toString()
}

fun String?.isNullOrEmptyOrBlank(): Boolean {
    return isNullOrEmpty() || isNullOrBlank()
}

fun String.toHex(): String {
    val array = toByteArray()
    val var1 = CharArray(array.size shl 1)
    var var2 = 0

    array.forEach {
        val var4: Int = (it and 255.toByte()).toInt()
        var1[var2++] = Constants.HEX_LOWERCASE[var4 ushr 4]
        var1[var2++] = Constants.HEX_LOWERCASE[var4 and 15]
    }
    return String(var1)
}

fun String.toHex(pass: String): String {
    val md = MessageDigest.getInstance("SHA-1")
    md.update(pass.toByteArray())
    val bytes = md.digest(this.toByteArray())
    val sb = StringBuilder()
    for (element in bytes) {
        sb.append(((element and 0xff.toByte()) + 0x100).toString(16).substring(1))
    }
    return sb.toString()
}

fun String.findStringOccurrencesAndIndex(stringToFind: String): ArrayList<Int> {
    val list = ArrayList<Int>()
    var index: Int = indexOf(stringToFind)
    while (index >= 0) {
        println(index)
        index = indexOf(stringToFind, index + 1)
        list.add(index)
    }
    return list
}

val Any.toJson: String
    get() {
        return try {
            Gson().toJson(this)
        } catch (e: Exception) {
            ""
        }
    }

fun String.getClickableSpan(
    toSpan: String,
    @ColorInt color: Int = 0,
    isHavingUnderline: Boolean = true,
    shouldBeBold: Boolean = false,
    clickEvent: (View) -> Unit
): SpannableString {
    val signUpSpan = object : ClickableSpan() {
        override fun onClick(widget: View) {
            widget.cancelPendingInputEvents()
            clickEvent.invoke(widget)
        }

        override fun updateDrawState(ds: TextPaint) {
            super.updateDrawState(ds)
            if (!isHavingUnderline) {
                ds.isUnderlineText = false
            }

            if (shouldBeBold) {
                ds.typeface = Typeface.DEFAULT_BOLD
            }
        }
    }

    val spanStartIndex = this.indexOf(toSpan)
    val spanEndIndex = spanStartIndex + toSpan.length
    val span = SpannableString(this)
    span.setSpan(
        signUpSpan,
        spanStartIndex,
        spanEndIndex,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )

    if (color != 0) {
        span.setSpan(
            ForegroundColorSpan(color),
            spanStartIndex,
            spanEndIndex,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }

    return span
}