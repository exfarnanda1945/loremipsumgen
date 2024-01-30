package com.exfarnanda1945.loremipsumgen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.exfarnanda1945.loremipsumgen.core.ui.theme.LoremipsumgenTheme
import com.exfarnanda1945.loremipsumgen.feat_generator.presentation.screen.generator.GeneratorScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoremipsumgenTheme {
                GeneratorScreen()
            }
        }
    }
}
