package com.exfarnanda1945.loremipsumgen.core.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

object DeviceUtils {
    fun copy(
        context: Context,
        data: String,
        onCopySuccess: () -> Unit,
        onCopyFailed: (msg: String?) -> Unit
    ) {
        val clipManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", data)

        try {
            clipManager.setPrimaryClip(clipData)
            onCopySuccess()
        } catch (e: Exception) {
            e.printStackTrace()
            onCopyFailed(e.localizedMessage)
        }
    }
}