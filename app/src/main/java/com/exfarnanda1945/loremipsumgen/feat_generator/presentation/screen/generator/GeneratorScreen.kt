package com.exfarnanda1945.loremipsumgen.feat_generator.presentation.screen.generator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.exfarnanda1945.loremipsumgen.core.ui.theme.LoremipsumgenTheme

@Composable
fun GeneratorScreen() {
    val generatorVm = hiltViewModel<GeneratorViewModel>()
    val state = generatorVm.generatorState

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(vertical = 16.dp, horizontal = 24.dp),
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
                generatorVm = generatorVm,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                ElevatedButton(
                    onClick = { /*TODO*/ },
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


@Preview
@Composable
fun GeneratorScreenPreview() {
    LoremipsumgenTheme {
        GeneratorScreen()
    }
}

@Preview
@Composable
fun GeneratorScreenDarkPreview() {
    LoremipsumgenTheme(darkTheme = true) {
        GeneratorScreen()
    }
}