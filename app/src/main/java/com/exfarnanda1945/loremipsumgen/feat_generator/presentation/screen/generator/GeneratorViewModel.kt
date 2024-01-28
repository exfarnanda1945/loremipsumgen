package com.exfarnanda1945.loremipsumgen.feat_generator.presentation.screen.generator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exfarnanda1945.loremipsumgen.core.utils.Resource
import com.exfarnanda1945.loremipsumgen.feat_generator.domain.repository.IGeneratorRepository
import com.exfarnanda1945.loremipsumgen.feat_generator.domain.usecase.GeneratorUseCase
import com.exfarnanda1945.loremipsumgen.feat_generator.utils.UrlParamGenerator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GeneratorViewModel @Inject constructor(private val repo: IGeneratorRepository) : ViewModel() {

    private val generatorUseCase by lazy {
        GeneratorUseCase(repo)
    }
    var generatorState by mutableStateOf(
        GeneratorState()
    )

    private val _result = MutableStateFlow<Resource<String>>(Resource.Loading())
    val result = _result.asStateFlow()

    val enabledGenerateBtn =
        !(generatorState.numOfParagraphs == "" || generatorState.numOfParagraphs.toInt() == 0)

    private fun generate() {
        val url = UrlParamGenerator.generate(generatorState)
        viewModelScope.launch {
            val result = generatorUseCase(url)
            result.collect {
                _result.value = it
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
        }
    }


}