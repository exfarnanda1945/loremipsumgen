package com.exfarnanda1945.loremipsumgen.core.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exfarnanda1945.loremipsumgen.core.presentation.ui.event.UiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<T> :ViewModel() {
    private var _mainChannel = Channel<UiEvent>()
    val mainChannel = _mainChannel.receiveAsFlow()

    protected fun sendUiEvent(uiEvent: UiEvent) {
        viewModelScope.launch {
            _mainChannel.send(uiEvent)
        }
    }
    abstract fun onEvent(event: T)
}