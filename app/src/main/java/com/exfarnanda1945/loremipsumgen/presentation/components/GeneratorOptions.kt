package com.exfarnanda1945.loremipsumgen.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GeneratorOptions(text: String, modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 14.dp)
    ) {
        Text(
            text,
            style = MaterialTheme.typography.titleSmall.copy(fontSize = 16.sp),
            modifier = Modifier.padding(bottom = 4.dp)
        )
        content()
    }
}