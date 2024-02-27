package com.exfarnanda1945.loremipsumgen.feat_generator.presentation.screen.generator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.exfarnanda1945.loremipsumgen.core.navigation.AppRoutes
import com.exfarnanda1945.loremipsumgen.core.ui.event.UiEvent
import com.exfarnanda1945.loremipsumgen.core.ui.viewmodel.BaseViewModel
import com.exfarnanda1945.loremipsumgen.core.utils.Resource
import com.exfarnanda1945.loremipsumgen.feat_generator.domain.usecase.GeneratorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GeneratorViewModel @Inject constructor(private val generatorUseCase: GeneratorUseCase) :
    BaseViewModel() {
    var generatorState by mutableStateOf(
        GeneratorState()
    )
        private set

    var optionState by mutableStateOf(
        OptionExpandState()
    )
        private set

    private var generateJob: Job? = null


    private fun generate() {
        if (generateJob != null) return
        sendUiEvent(UiEvent.ShowLoading(true))

        generateJob = viewModelScope.launch {
            when (val result = generatorUseCase(generatorState)) {
                is Resource.Failure -> {
                    sendUiEvent(UiEvent.ShowLoading(false))
                    generateJob = null
                    sendUiEvent(UiEvent.ShowToast(result.message))

                }

                is Resource.Success -> {
                    sendUiEvent(UiEvent.ShowLoading(false))
                    sendUiEvent(
                        UiEvent.NavigateTo(
                            AppRoutes.ResultGenScreen.setResult(result = result.data!!)
                        )
                    )
                    generateJob = null
                }
            }
        }

    }

    fun onEvent(event: GeneratorEvent) {
        when (event) {
            is GeneratorEvent.OnBlockquoteChecked -> generatorState = generatorState.copy(
                addBq = event.blockquote
            )

            is GeneratorEvent.OnBoldChecked -> generatorState = generatorState.copy(
                isDecorate = event.boldItalic
            )

            is GeneratorEvent.OnCodeChecked -> generatorState = generatorState.copy(
                addCode = event.code
            )

            is GeneratorEvent.OnDescriptionListChecked -> generatorState = generatorState.copy(
                addDl = event.descriptionList
            )

            GeneratorEvent.OnGenerateBtnClick -> {
                generate()
            }

            is GeneratorEvent.OnHeadingChecked -> generatorState = generatorState.copy(
                addHeaders = event.heading
            )

            is GeneratorEvent.OnLinksChecked -> generatorState = generatorState.copy(
                addLink = event.link
            )

            is GeneratorEvent.OnNumOfParagraphChange -> generatorState = generatorState.copy(
                numOfParagraphs = event.numOfParagraph
            )

            is GeneratorEvent.OnOrderedListChecked -> generatorState = generatorState.copy(
                addOl = event.orderedList
            )

            is GeneratorEvent.OnParagraphLengthChange -> generatorState = generatorState.copy(
                paragraphLength = event.paragraphLength
            )

            is GeneratorEvent.OnPrudeVerChecked -> generatorState = generatorState.copy(
                prudeVer = event.prudeVer
            )

            is GeneratorEvent.OnUnorderedListChecked -> generatorState = generatorState.copy(
                addUl = event.unorderedList
            )

            is GeneratorEvent.OnUseAllCapsChecked -> {
                generatorState = generatorState.copy(
                    addAllCaps = event.useAllCaps
                )
            }

            GeneratorEvent.OnParagraphLengthShow -> {
                generatorState = generatorState.copy(
                    isParagraphLengthShow = !generatorState.isParagraphLengthShow
                )
            }

            is GeneratorEvent.OnReturnPlainTextChange -> {
                generatorState = generatorState.copy(
                    returnPlainText = !generatorState.returnPlainText
                )
            }

            GeneratorEvent.OnResetOption -> {
                generatorState = GeneratorState()
            }

            is GeneratorEvent.OnHtmlOptionExpanded -> {
                optionState = optionState.copy(
                    isHtmlOptionExpand = !optionState.isHtmlOptionExpand
                )
            }

            is GeneratorEvent.OnMoreOptionExpanded -> {
                optionState = optionState.copy(
                    isMoreOptionExpand = !optionState.isMoreOptionExpand
                )
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        generateJob = null
    }

    val enabledGenerateBtn =
        !(generatorState.numOfParagraphs == "" || generatorState.numOfParagraphs.toInt() == 0)
}