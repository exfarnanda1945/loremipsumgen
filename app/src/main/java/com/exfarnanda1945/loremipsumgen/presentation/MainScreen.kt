package com.exfarnanda1945.loremipsumgen.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.platform.LocalContext
import com.exfarnanda1945.loremipsumgen.presentation.generator.GeneratorScreen
import com.exfarnanda1945.loremipsumgen.presentation.generator.GeneratorViewModel
import com.exfarnanda1945.loremipsumgen.presentation.no_connection.NoConnectionScreen
import com.exfarnanda1945.loremipsumgen.utils.ConnectionState
import com.exfarnanda1945.loremipsumgen.utils.currentConnectionState
import com.exfarnanda1945.loremipsumgen.utils.observeConnectivityAsFlow

@Composable
fun MainScreen(mViewModel: GeneratorViewModel) {
    val context = LocalContext.current
    val connected by produceState(initialValue = context.currentConnectionState){
        context.observeConnectivityAsFlow().collect{
            value = it
        }
    }

    when(connected){
        ConnectionState.Available -> GeneratorScreen(mViewModel,context)
        ConnectionState.Unavailable -> NoConnectionScreen()
    }

}