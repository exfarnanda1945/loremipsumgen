package com.exfarnanda1945.loremipsumgen.feat_generator.presentation.screen.generator

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavHostController
import com.exfarnanda1945.loremipsumgen.core.presentation.ui.event.UiEvent

@Composable
fun GeneratorScreen(navHostController: NavHostController) {
    val generatorVm = hiltViewModel<GeneratorViewModel>()
    val state = generatorVm.generatorState
    val optionState = generatorVm.optionState
    val lifecycle = LocalLifecycleOwner.current
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    LaunchedEffect(lifecycle) {
        lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            generatorVm.uiChannel.collect { uiEvent ->
                when (uiEvent) {
                    is UiEvent.NavigateTo -> navHostController.navigate(uiEvent.path)
                    is UiEvent.ShowToast -> Toast.makeText(context, uiEvent.msg, Toast.LENGTH_SHORT)
                        .show()

                    is UiEvent.ShowLoading -> showDialog = uiEvent.isLoading
                    else -> {}
                }
            }
        }
    }

    LaunchedEffect(true) {
        generatorVm.onEvent(GeneratorEvent.OnResetOption)
    }

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(vertical = 16.dp, horizontal = 24.dp)
//                .verticalScroll(scrollState),

        ) {
            Text(
                text = "loremipsum.gen",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                ),
            )
            GeneratorForm(
                state = state,
                optionState = optionState,
                generatorVm = generatorVm,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.fillMaxSize(),
            ) {
                Column {
                    Text(
                        text = "View saved results here",
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(
                            textDecoration = TextDecoration.Underline,
                            color = MaterialTheme.colorScheme.primary
                        ),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(14.dp),
                    ) {
                        ElevatedButton(
                            onClick = {
                                generatorVm.onEvent(GeneratorEvent.OnGenerateBtnClick)
                            },
                            shape = RoundedCornerShape(8.dp),
                            enabled = generatorVm.enabledGenerateBtn,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                contentColor = MaterialTheme.colorScheme.onPrimary
                            ),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Generate")
                        }
                        ElevatedButton(
                            onClick = { generatorVm.onEvent(GeneratorEvent.OnResetOption) },
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.onSecondary,
                                contentColor = MaterialTheme.colorScheme.secondary
                            ),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Reset")
                        }
                    }
                }
            }

        }
    }

    if (showDialog) {
        Dialog(
            onDismissRequest = { showDialog = false },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            ),
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(4.dp)
                    )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.align(
                        Alignment.Center
                    )
                ) {
                    CircularProgressIndicator()
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Generating...", textAlign = TextAlign.Center)
                }
            }
        }
    }
}
