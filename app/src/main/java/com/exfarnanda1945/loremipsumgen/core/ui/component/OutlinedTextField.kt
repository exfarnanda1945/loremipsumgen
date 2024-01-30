package com.exfarnanda1945.loremipsumgen.core.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OutlinedTextField(
    title: String, value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Next
    ),
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            title, style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W500
            )
        )
        OutlinedTextField(
            maxLines = 1,
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            keyboardOptions = keyboardOptions
        )
    }
}
