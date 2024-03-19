package com.exfarnanda1945.loremipsumgen.core.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.util.Log

object DeviceUtils {
    fun copy(
        context: Context,
        data: String,
    ) {
        val clipManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", data)

        try {
            clipManager.setPrimaryClip(clipData)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("DeviceUtils", "copy: ${e.localizedMessage}")
        }
    }
}