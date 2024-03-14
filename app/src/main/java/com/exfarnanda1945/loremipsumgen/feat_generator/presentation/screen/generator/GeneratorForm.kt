package com.exfarnanda1945.loremipsumgen.feat_generator.presentation.screen.generator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exfarnanda1945.loremipsumgen.core.presentation.ui.component.CheckBoxLabel
import com.exfarnanda1945.loremipsumgen.core.presentation.ui.component.DropDownField
import com.exfarnanda1945.loremipsumgen.core.presentation.ui.component.OutlinedTextField
import com.exfarnanda1945.loremipsumgen.feat_generator.presentation.component.GeneratorOptions
import com.exfarnanda1945.loremipsumgen.feat_generator.utils.ParagraphLengthEnum

@Composable
fun GeneratorForm(
    state: GeneratorState,
    optionState: OptionExpandState,
    generatorVm: GeneratorViewModel,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            title = "Number of Paragraph (Max 20)",
            value = state.numOfParagraphs,
            onValueChange = {
                generatorVm.onEvent(GeneratorEvent.OnNumOfParagraphChange(it))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
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
            isExpanded = optionState.isMoreOptionExpand,
            onExpandedClick = { generatorVm.onEvent(GeneratorEvent.OnMoreOptionExpanded) }) {
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                CheckBoxLabel(
                    checked = state.isAllCaps,
                    onCheckedChange = {
                        generatorVm.onEvent(GeneratorEvent.OnUseAllCapsChecked(it))
                    },
                    label = "Use All Caps"
                )
                CheckBoxLabel(
                    checked = state.isPrudeVer,
                    onCheckedChange = {
                        generatorVm.onEvent(GeneratorEvent.OnPrudeVerChecked(it))
                    },
                    label = "Prude Version"
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        GeneratorOptions(title = "Add Other HTML Elements",
            isExpanded = optionState.isHtmlOptionExpand,
            onExpandedClick = { generatorVm.onEvent(GeneratorEvent.OnHtmlOptionExpanded) }) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    CheckBoxLabel(
                        checked = state.isLink,
                        onCheckedChange = {
                            generatorVm.onEvent(GeneratorEvent.OnLinksChecked(it))
                        },
                        label = "Links"
                    )
                    CheckBoxLabel(
                        checked = state.isUl,
                        onCheckedChange = {
                            generatorVm.onEvent(GeneratorEvent.OnUnorderedListChecked(it))
                        },
                        label = "Unordered List"
                    )
                    CheckBoxLabel(
                        checked = state.isOl,
                        onCheckedChange = {
                            generatorVm.onEvent(GeneratorEvent.OnOrderedListChecked(it))
                        },
                        label = "Ordered List"
                    )
                    CheckBoxLabel(
                        checked = state.isDl,
                        onCheckedChange = {
                            generatorVm.onEvent(GeneratorEvent.OnDescriptionListChecked(it))
                        },
                        label = "Description List"
                    )
                    Column(modifier = Modifier.padding(vertical = 12.dp)) {
                        Text(
                            text = "Return as", style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W500
                            )
                        )
                        Row {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                RadioButton(
                                    selected = !state.isReturnPlainText,
                                    onClick = {
                                        generatorVm.onEvent(
                                            GeneratorEvent.OnReturnPlainTextChange(
                                                false
                                            )
                                        )
                                    }
                                )
                                Text(
                                    text = "Html",
                                    style = TextStyle(
                                        fontSize = 14.sp
                                    ),
                                    modifier = Modifier.padding(start = 2.dp)
                                )
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                RadioButton(
                                    selected = state.isReturnPlainText,
                                    onClick = {
                                        generatorVm.onEvent(
                                            GeneratorEvent.OnReturnPlainTextChange(
                                                true
                                            )
                                        )
                                    }
                                )
                                Text(
                                    text = "Plain Text",
                                    style = TextStyle(
                                        fontSize = 14.sp
                                    ),
                                    modifier = Modifier.padding(start = 2.dp)
                                )
                            }
                        }
                    }

                }
                Column {
                    CheckBoxLabel(
                        checked = state.isBq,
                        onCheckedChange = {
                            generatorVm.onEvent(GeneratorEvent.OnBlockquoteChecked(it))
                        },
                        label = "Blockquote"
                    )
                    CheckBoxLabel(
                        checked = state.isCode,
                        onCheckedChange = {
                            generatorVm.onEvent(GeneratorEvent.OnCodeChecked(it))
                        },
                        label = "Code"
                    )
                    CheckBoxLabel(
                        checked = state.isHeaders,
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
    }
}