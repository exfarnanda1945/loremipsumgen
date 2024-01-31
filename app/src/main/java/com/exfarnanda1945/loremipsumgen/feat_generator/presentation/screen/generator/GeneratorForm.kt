package com.exfarnanda1945.loremipsumgen.feat_generator.presentation.screen.generator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.exfarnanda1945.loremipsumgen.core.ui.component.CheckBoxLabel
import com.exfarnanda1945.loremipsumgen.core.ui.component.DropDownField
import com.exfarnanda1945.loremipsumgen.core.ui.component.OutlinedTextField
import com.exfarnanda1945.loremipsumgen.feat_generator.presentation.component.GeneratorOptions
import com.exfarnanda1945.loremipsumgen.feat_generator.utils.ParagraphLengthEnum

@Composable
fun GeneratorForm(state:GeneratorState,generatorVm:GeneratorViewModel,modifier:Modifier = Modifier) {
    Column(modifier=modifier) {
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
    }
}