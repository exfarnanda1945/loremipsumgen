package com.exfarnanda1945.loremipsumgen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.exfarnanda1945.loremipsumgen.presentation.MainScreen
import com.exfarnanda1945.loremipsumgen.presentation.generator.GeneratorViewModel
import com.exfarnanda1945.loremipsumgen.ui.theme.LoremipsumgenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mViewModel = ViewModelProvider(this)[GeneratorViewModel::class.java]
        setContent {
            LoremipsumgenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(mViewModel = mViewModel)
                }
            }
        }
    }
}
