package com.exfarnanda1945.loremipsumgen.feat_result.presentation.result

import android.content.Context
import com.exfarnanda1945.loremipsumgen.core.presentation.ui.event.UiEvent
import com.exfarnanda1945.loremipsumgen.core.presentation.ui.viewmodel.BaseViewModel
import com.exfarnanda1945.loremipsumgen.core.utils.DeviceUtils
import com.exfarnanda1945.loremipsumgen.feat_result.domain.usecase.ResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    @ApplicationContext private val appContext: Context,
    private val useCase: ResultUseCase
) :
    BaseViewModel<ResultEvent>() {
    override fun onEvent(event: ResultEvent) {
        when (event) {
            is ResultEvent.OnCopyClipboard -> {
                DeviceUtils.copy(context = appContext, data = event.result, onCopySuccess = {
                    sendUiEvent(UiEvent.ShowSnackBar("Result copied !"))
                }, onCopyFailed = {
                    sendUiEvent(UiEvent.ShowSnackBar("$it"))
                })
            }

            is ResultEvent.OnSaveResult -> {

            }
        }
    }

}