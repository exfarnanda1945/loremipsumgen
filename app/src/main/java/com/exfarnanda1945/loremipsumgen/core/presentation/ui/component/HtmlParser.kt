package com.exfarnanda1945.loremipsumgen.core.presentation.ui.component

import android.text.util.Linkify
import android.widget.TextView
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import com.exfarnanda1945.loremipsumgen.R

@Composable
fun HtmlParser(text: String, modifier: Modifier = Modifier) {
    val textColor = if (isSystemInDarkTheme()) R.color.white else R.color.black
    AndroidView(modifier = modifier, factory = { context ->
        TextView(context).apply {
            textSize = 14f
            autoLinkMask = Linkify.WEB_URLS
            linksClickable = true
            setTextColor(resources.getColor(textColor, null))
            setLinkTextColor(context.getColor(R.color.purple))
            setText(HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY))
        }
    })
}