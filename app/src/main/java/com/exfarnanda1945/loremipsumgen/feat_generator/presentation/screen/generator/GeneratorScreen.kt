package com.exfarnanda1945.loremipsumgen.feat_generator.presentation.screen.generator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exfarnanda1945.loremipsumgen.core.ui.component.CheckBoxLabel
import com.exfarnanda1945.loremipsumgen.core.ui.component.DropDownField
import com.exfarnanda1945.loremipsumgen.core.ui.component.OutlinedTextField
import com.exfarnanda1945.loremipsumgen.core.ui.theme.LoremipsumgenTheme
import com.exfarnanda1945.loremipsumgen.feat_generator.presentation.component.GeneratorOptions
import com.exfarnanda1945.loremipsumgen.feat_generator.utils.ParagraphLengthEnum

@Composable
fun GeneratorScreen() {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
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
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                title = "Number of Paragraph",
                value = "0",
                onValueChange = {
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            DropDownField(
                title = "Paragraph Length",
                isExpanded = false,
                onExpandedChange = {},
                onDismissRequest = { /*TODO*/ },
                value = "Small",
                dropDownContent = {
                    ParagraphLengthEnum.values().forEach {
                        DropdownMenuItem(text = {
                            Text(text = it.name)
                        }, onClick = {})
                    }
                })
            Spacer(modifier = Modifier.height(12.dp))
            GeneratorOptions(title = "Options") {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    CheckBoxLabel(
                        checked = true,
                        onCheckedChange = {},
                        label = "Use All Caps"
                    )
                    CheckBoxLabel(
                        checked = true,
                        onCheckedChange = {},
                        label = "Prude Version"
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            GeneratorOptions(title = "Add Other HTML Elements") {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        CheckBoxLabel(
                            checked = true,
                            onCheckedChange = {},
                            label = "Links"
                        )
                        CheckBoxLabel(
                            checked = true,
                            onCheckedChange = {},
                            label = "Unordered List"
                        )
                        CheckBoxLabel(
                            checked = true,
                            onCheckedChange = {},
                            label = "Ordered List"
                        )
                        CheckBoxLabel(
                            checked = true,
                            onCheckedChange = {},
                            label = "Description List"
                        )
                        CheckBoxLabel(
                            checked = true,
                            onCheckedChange = {},
                            label = "Return text as ${if (true) "Text" else "Html"}"
                        )
                    }
                    Column {
                        CheckBoxLabel(
                            checked = true,
                            onCheckedChange = {},
                            label = "Blockquote"
                        )
                        CheckBoxLabel(
                            checked = true,
                            onCheckedChange = {},
                            label = "Code"
                        )
                        CheckBoxLabel(
                            checked = true,
                            onCheckedChange = {},
                            label = "Heading"
                        )
                        CheckBoxLabel(
                            checked = true,
                            onCheckedChange = {},
                            label = "Bold and Italic"
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ElevatedButton(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Text(text = "Generate")
                }
                ElevatedButton(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onSecondary,
                        contentColor = MaterialTheme.colorScheme.secondary
                    )
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