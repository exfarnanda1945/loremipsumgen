package com.exfarnanda1945.loremipsumgen.feat_result.presentation.result

import android.content.Context
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.exfarnanda1945.loremipsumgen.core.domain.models.GeneratorSetting
import com.exfarnanda1945.loremipsumgen.core.domain.models.HistoryGenerator
import com.exfarnanda1945.loremipsumgen.core.presentation.ui.event.UiEvent
import com.exfarnanda1945.loremipsumgen.core.presentation.ui.viewmodel.BaseViewModel
import com.exfarnanda1945.loremipsumgen.core.utils.DeviceUtils
import com.exfarnanda1945.loremipsumgen.core.utils.JsonUtils
import com.exfarnanda1945.loremipsumgen.core.utils.Resource
import com.exfarnanda1945.loremipsumgen.feat_result.domain.usecase.ResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.ZoneOffset
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    @ApplicationContext private val appContext: Context,
    private val useCase: ResultUseCase,
    private val jsonUtils: JsonUtils
) :
    BaseViewModel<ResultEvent>() {
    override fun onEvent(event: ResultEvent) {
        when (event) {
            is ResultEvent.OnCopyClipboard -> {
                DeviceUtils.copy(context = appContext, data = event.result)
            }

            is ResultEvent.OnSaveResult -> viewModelScope.launch {
                val setting = jsonUtils.fromJson<GeneratorSetting>(event.settings)
                val now = LocalDateTime.now()
                val data = HistoryGenerator(
                    result = event.result,
                    setting = setting,
                    createdAt = now.toEpochSecond(ZoneOffset.UTC)
                )

                when (val insert = useCase(data)) {
                    is Resource.Failure -> {
                        sendUiEvent(UiEvent.ShowToast(insert.message))
                        Log.e("failure", "onEvent: ${insert.message}")
                    }

                    is Resource.Success -> {
                        sendUiEvent(UiEvent.ShowSnackBar("Result successfully saved"))
                        sendUiEvent(UiEvent.NavigateBack)
                    }
                }
            }
        }
    }

}