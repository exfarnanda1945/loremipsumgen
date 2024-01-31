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
import androidx.hilt.navigation.compose.hiltViewModel
import com.exfarnanda1945.loremipsumgen.core.ui.component.CheckBoxLabel
import com.exfarnanda1945.loremipsumgen.core.ui.component.DropDownField
import com.exfarnanda1945.loremipsumgen.core.ui.component.OutlinedTextField
import com.exfarnanda1945.loremipsumgen.core.ui.theme.LoremipsumgenTheme
import com.exfarnanda1945.loremipsumgen.feat_generator.presentation.component.GeneratorOptions
import com.exfarnanda1945.loremipsumgen.feat_generator.utils.ParagraphLengthEnum

@Composable
fun GeneratorScreen() {
    val generatorVm = hiltViewModel<GeneratorViewModel>()
    val state = generatorVm.generatorState

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
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
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                title = "Number of Paragraph",
                value = state.numOfParagraphs,
                onValueChange = {
                    generatorVm.onEvent(GeneratorEvent.OnNumOfParagraphChange(it))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            DropDownField(
                title = "Paragraph Length",
                isExpanded = state.isParagraphLengthShow,
                onExpandedChange = {
                    generatorVm.onEvent(GeneratorEvent.OnParagraphLengthShow)
                },
                onDismissRequest = {
                    generatorVm.onEvent(GeneratorEvent.OnParagraphLengthShow)
                },
                value = state.paragraphLength.name,
                dropDownContent = {
                    ParagraphLengthEnum.values().forEach {
                        DropdownMenuItem(text = {
                            Text(text = it.name)
                        }, onClick = {
                            generatorVm.apply {
                                onEvent(GeneratorEvent.OnParagraphLengthChange(it))
                                onEvent(GeneratorEvent.OnParagraphLengthShow)
                            }
                        })
                    }
                })
            Spacer(modifier = Modifier.height(12.dp))
            GeneratorOptions(
                title = "Options",
                isExpanded = state.isMoreOptionExpand,
                onExpandedClick = { generatorVm.onEvent(GeneratorEvent.OnMoreOptionExpanded) }) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    CheckBoxLabel(
                        checked = state.addAllCaps,
                        onCheckedChange = {
                            generatorVm.onEvent(GeneratorEvent.OnUseAllCapsChecked(it))
                        },
                        label = "Use All Caps"
                    )
                    CheckBoxLabel(
                        checked = state.prudeVer,
                        onCheckedChange = {
                            generatorVm.onEvent(GeneratorEvent.OnPrudeVerChecked(it))
                        },
                        label = "Prude Version"
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            GeneratorOptions(title = "Add Other HTML Elements",
                isExpanded = state.isHtmlOptionExpand,
                onExpandedClick = { generatorVm.onEvent(GeneratorEvent.OnHtmlOptionExpanded) }) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        CheckBoxLabel(
                            checked = state.addLink,
                            onCheckedChange = {
                                generatorVm.onEvent(GeneratorEvent.OnLinksChecked(it))
                            },
                            label = "Links"
                        )
                        CheckBoxLabel(
                            checked = state.addUl,
                            onCheckedChange = {
                                generatorVm.onEvent(GeneratorEvent.OnUnorderedListChecked(it))
                            },
                            label = "Unordered List"
                        )
                        CheckBoxLabel(
                            checked = state.addOl,
                            onCheckedChange = {
                                generatorVm.onEvent(GeneratorEvent.OnOrderedListChecked(it))
                            },
                            label = "Ordered List"
                        )
                        CheckBoxLabel(
                            checked = state.addDl,
                            onCheckedChange = {
                                generatorVm.onEvent(GeneratorEvent.OnDescriptionListChecked(it))
                            },
                            label = "Description List"
                        )
                        CheckBoxLabel(
                            checked = state.returnPlainText,
                            onCheckedChange = {
                                generatorVm.onEvent(GeneratorEvent.OnReturnPlainTextChange(it))
                            },
                            label = "Return text as ${if (state.returnPlainText) "Text" else "Html"}"
                        )
                    }
                    Column {
                        CheckBoxLabel(
                            checked = state.addBq,
                            onCheckedChange = {
                                generatorVm.onEvent(GeneratorEvent.OnBlockquoteChecked(it))
                            },
                            label = "Blockquote"
                        )
                        CheckBoxLabel(
                            checked = state.addCode,
                            onCheckedChange = {
                                generatorVm.onEvent(GeneratorEvent.OnCodeChecked(it))
                            },
                            label = "Code"
                        )
                        CheckBoxLabel(
                            checked = state.addHeaders,
                            onCheckedChange = {
                                generatorVm.onEvent(GeneratorEvent.OnHeadingChecked(it))
                            },
                            label = "Heading"
                        )
                        CheckBoxLabel(
                            checked = state.isDecorate,
                            onCheckedChange = {
                                generatorVm.onEvent(GeneratorEvent.OnBoldChecked(it))
                            },
                            label = "Bold and Italic"
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
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