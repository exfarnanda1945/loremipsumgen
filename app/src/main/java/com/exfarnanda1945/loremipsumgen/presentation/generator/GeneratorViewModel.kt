package com.exfarnanda1945.loremipsumgen.presentation.generator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exfarnanda1945.loremipsumgen.data.HttpUtils
import com.exfarnanda1945.loremipsumgen.data.Resource
import com.exfarnanda1945.loremipsumgen.domain.GeneratorService
import com.exfarnanda1945.loremipsumgen.utils.UrlParamGenerator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GeneratorViewModel : ViewModel() {
    private val service by lazy {
        GeneratorService(HttpUtils.generatorService)
    }

    private var _generateResult = MutableStateFlow<Resource<String>>(Resource.Loading())
    val generateResult: StateFlow<Resource<String>> = _generateResult.asStateFlow()

    var generatorState by mutableStateOf(
        GeneratorState()
    )

    private fun generate() {
        val url = UrlParamGenerator.generate(generatorState)
        viewModelScope.launch {
            val result = service.generate(url)
            result.collect {
                _generateResult.value = it
            }
        }
    }


    fun onEvent(event: GeneratorEvent) {
        when (event) {
            is GeneratorEvent.OnBlockquoteSwitchChange -> generatorState = generatorState.copy(
                addBq = event.blockquote
            )

            is GeneratorEvent.OnBoldSwitchChange -> generatorState = generatorState.copy(
                isDecorate = event.boldItalic
            )

            is GeneratorEvent.OnCodeSwitchChange -> generatorState = generatorState.copy(
                addCode = event.code
            )

            is GeneratorEvent.OnDescriptionListSwitchChange -> generatorState = generatorState.copy(
                addDl = event.descriptionList
            )

            GeneratorEvent.OnGenerateBtnClick -> {
                generate()
            }

            is GeneratorEvent.OnHeadingSwitchChange -> generatorState = generatorState.copy(
                addHeaders = event.heading
            )

            is GeneratorEvent.OnLinksSwitchChange -> generatorState = generatorState.copy(
                addLink = event.link
            )

            is GeneratorEvent.OnNumOfParagraphChange -> generatorState = generatorState.copy(
                numOfParagraphs = event.numOfParagraph
            )

            is GeneratorEvent.OnOrderedListSwitchChange -> generatorState = generatorState.copy(
                addOl = event.orderedList
            )

            is GeneratorEvent.OnParagraphLengthChange -> generatorState = generatorState.copy(
                paragraphLength = event.paragraphLength
            )

            is GeneratorEvent.OnPrudeVerSwitchChange -> generatorState = generatorState.copy(
                prudeVer = event.prudeVer
            )

            is GeneratorEvent.OnUnorderedListSwitchChange -> generatorState = generatorState.copy(
                addUl = event.unorderedList
            )

            is GeneratorEvent.OnUseAllCapsSwitchChange -> {
                generatorState = generatorState.copy(
                    addAllCaps = event.useAllCaps
                )
            }

            GeneratorEvent.OnParagraphLengthShow -> {
                generatorState = generatorState.copy(
                    isParagraphLengthShow = !generatorState.isParagraphLengthShow
                )
            }
        }
    }

    fun enabledGenerateBtn(): Boolean {
        if (generatorState.numOfParagraphs == "") {
            return false
        }

        if (generatorState.numOfParagraphs.toInt() == 0) {
            return false
        }

        return true
    }
}