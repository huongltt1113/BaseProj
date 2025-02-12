package com.dev.baseproject.extension

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import com.dev.baseproject.App
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

object IntentUtils {

    fun openById(id: String?) {
        val url = id ?: return
        openById(App.instance, url, null)
    }

    private fun openById(context: Context, id: String, `is`: InputStream?) {
        var id = id
        if (`is` != null) {
            val reader = BufferedReader(InputStreamReader(`is`))
            try {
                reader.readLine()
            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                try {
                    `is`.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        try {
            if (id.indexOf("referrer") < 0) {
                id += "&referrer=utm_source%3Dtpcom%26utm_medium%3D" + context.packageName.replace(
                    ".", "_"
                ) + "%26utm_campaign%3Dmoreapp"
            }
            if (id.startsWith("http")) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(id))
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                context.startActivity(intent)
            } else {
                try {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$id"))
                    intent.flags =
                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                    context.startActivity(intent)
                } catch (anfe: ActivityNotFoundException) {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=$id")
                    )
                    intent.flags =
                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                    context.startActivity(intent)
                }
            }
        } catch (e: Exception) {
            Log.e("Error: ", "tag", e)
        }
    }

    fun share(activity: Activity, uri: Uri, mineType: String, name: String? = null): Boolean {
        return try {
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_STREAM, uri)
                data = uri
                type = mineType
                flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            }
            activity.startActivity(Intent.createChooser(intent, "Share ${name ?: ""}"))
            true
        } catch (e: Exception) {
            false
        }
    }

    fun shareUrl(activity: Activity?, url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        activity?.startActivity(intent)
    }

    fun shareText(activity: Activity?, title: String? = null, text: String? = "") {
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, title)
        shareIntent.type = "*/*"
        shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        shareIntent.putExtra(Intent.EXTRA_TEXT, text)
        activity?.startActivity(Intent.createChooser(shareIntent, ""))
    }
}