package com.exfarnanda1945.loremipsumgen.presentation.generator

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.exfarnanda1945.loremipsumgen.presentation.components.BottomSheetContent
import com.exfarnanda1945.loremipsumgen.presentation.components.GeneratorOptions
import com.exfarnanda1945.loremipsumgen.presentation.components.SwitchLabel
import com.exfarnanda1945.loremipsumgen.utils.ParagraphLengthEnum
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneratorScreen(mViewModel: GeneratorViewModel, context: Context) {

    val state = mViewModel.generatorState
    val bmState = rememberBottomSheetScaffoldState(
        bottomSheetState = SheetState(
            skipPartiallyExpanded = true
        )
    )
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val result by mViewModel.generateResult.collectAsStateWithLifecycle()

    BottomSheetScaffold(
        scaffoldState = bmState,
        sheetSwipeEnabled = false,
        sheetContent = {
            BottomSheetContent(
                result = result,
                context = context,
                scrollState = scrollState,
                bmState = bmState,
                scope = scope,
                onCopyResult = {
                    copyResult(context,it)
                }
            )
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Lorem Ipsum Generator",
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 18.sp
                        )
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = state.numOfParagraphs,
                    onValueChange = {
                        mViewModel.onEvent(GeneratorEvent.OnNumOfParagraphChange(it))
                    },
                    label = {
                        Text("Number of Paragraphs")
                    },
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .weight(1f),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    )
                )

                ExposedDropdownMenuBox(
                    expanded = state.isParagraphLengthShow,
                    onExpandedChange = {
                        mViewModel.onEvent(GeneratorEvent.OnParagraphLengthShow)
                    },
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .weight(1f)
                ) {
                    TextField(
                        value = state.paragraphLength.name,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = state.isParagraphLengthShow)
                        },
                        colors = ExposedDropdownMenuDefaults.textFieldColors(),
                        modifier = Modifier.menuAnchor(),
                        label = {
                            Text(text = "Paragraph Length")
                        }
                    )
                    ExposedDropdownMenu(
                        expanded = state.isParagraphLengthShow,
                        onDismissRequest = { mViewModel.onEvent(GeneratorEvent.OnParagraphLengthShow) }) {
                        ParagraphLengthEnum.values().forEach {
                            DropdownMenuItem(text = {
                                Text(text = it.name)
                            }, onClick = {
                                mViewModel.apply {
                                    onEvent(GeneratorEvent.OnParagraphLengthChange(it))
                                    onEvent(GeneratorEvent.OnParagraphLengthShow)
                                }
                            })
                        }
                    }
                }
            }

            GeneratorOptions(text = "Options") {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    SwitchLabel(
                        checked = state.addAllCaps,
                        onCheckedChange = {
                            mViewModel.onEvent(GeneratorEvent.OnUseAllCapsSwitchChange(it))
                        },
                        label = "Use All Caps"
                    )
                    SwitchLabel(
                        checked = state.prudeVer,
                        onCheckedChange = {
                            mViewModel.onEvent(GeneratorEvent.OnPrudeVerSwitchChange(it))
                        },
                        label = "Prude Version"
                    )
                }
            }

            GeneratorOptions(text = "Add Other HTML Elements") {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column {
                        SwitchLabel(
                            checked = state.addLink,
                            onCheckedChange = {
                                mViewModel.onEvent(GeneratorEvent.OnLinksSwitchChange(it))
                            },
                            label = "Links"
                        )
                        SwitchLabel(
                            checked = state.addUl,
                            onCheckedChange = {
                                mViewModel.onEvent(GeneratorEvent.OnUnorderedListSwitchChange(it))
                            },
                            label = "Unordered List"
                        )
                        SwitchLabel(
                            checked = state.addOl,
                            onCheckedChange = {
                                mViewModel.onEvent(GeneratorEvent.OnOrderedListSwitchChange(it))
                            },
                            label = "Ordered List"
                        )
                        SwitchLabel(
                            checked = state.addDl,
                            onCheckedChange = {
                                mViewModel.onEvent(GeneratorEvent.OnDescriptionListSwitchChange(it))
                            },
                            label = "Description List"
                        )
                        SwitchLabel(
                            checked = state.returnPlainText,
                            onCheckedChange = {
                                mViewModel.onEvent(GeneratorEvent.OnReturnPlainTextChange(it))
                            },
                            label = "Return text as ${if(state.returnPlainText) "Text" else "Html"}"
                        )
                    }
                    Column {
                        SwitchLabel(
                            checked = state.addBq,
                            onCheckedChange = {
                                mViewModel.onEvent(GeneratorEvent.OnBlockquoteSwitchChange(it))
                            },
                            label = "Blockquote"
                        )
                        SwitchLabel(
                            checked = state.addCode,
                            onCheckedChange = {
                                mViewModel.onEvent(GeneratorEvent.OnCodeSwitchChange(it))
                            }, label = "Code"
                        )
                        SwitchLabel(
                            checked = state.addHeaders,
                            onCheckedChange = {
                                mViewModel.onEvent(GeneratorEvent.OnHeadingSwitchChange(it))
                            },
                            label = "Heading"
                        )
                        SwitchLabel(
                            checked = state.isDecorate,
                            onCheckedChange = {
                                mViewModel.onEvent(GeneratorEvent.OnBoldSwitchChange(it))
                            }, label = "Bold and Italic"
                        )
                    }
                }
            }
            ElevatedButton(
                onClick = {
                    mViewModel.onEvent(GeneratorEvent.OnGenerateBtnClick)
                    scope.launch {
                        bmState.bottomSheetState.show()
                    }
                },
                enabled = mViewModel.enabledGenerateBtn(),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 8.dp, end = 8.dp)
            ) {
                Text("Generate")
            }
        }
    }


}

fun copyResult(context: Context, result: String) {
    val clipBoard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clipData =ClipData.newPlainText("result",result)
    clipBoard.setPrimaryClip(clipData)
    Toast.makeText(context,"Result copied",Toast.LENGTH_SHORT).show()
}
