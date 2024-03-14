package com.exfarnanda1945.loremipsumgen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.exfarnanda1945.loremipsumgen.core.presentation.navigation.AppNavGraph
import com.exfarnanda1945.loremipsumgen.core.presentation.ui.theme.LoremipsumgenTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoremipsumgenTheme {
                val navHostController = rememberNavController()
                AppNavGraph(navHostController = navHostController)
            }
        }
    }
}
