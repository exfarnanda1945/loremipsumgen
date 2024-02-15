package com.exfarnanda1945.loremipsumgen.feat_generator.presentation.screen.result

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ResultScreen(
    result: String,
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Scaffold {
        Column(
            modifier = modifier
                .padding(it)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .verticalScroll(scrollState)
            ) {
//                HtmlParser(text = result)
                Text(text = result)
            }
        }
    }


}