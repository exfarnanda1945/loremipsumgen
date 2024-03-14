package com.exfarnanda1945.loremipsumgen.feat_generator.presentation.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GeneratorOptions(
    title: String,
    isExpanded: Boolean,
    onExpandedClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 14.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onExpandedClick()
                },
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                title,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500
                ),
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Icon(
                imageVector = if (isExpanded)
                    Icons.Filled.KeyboardArrowDown else
                    Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "",
                modifier = Modifier
                    .padding(end = 20.dp)

            )
        }
        AnimatedVisibility(
            visible = isExpanded,
        ) {
            content()
        }
    }
}
