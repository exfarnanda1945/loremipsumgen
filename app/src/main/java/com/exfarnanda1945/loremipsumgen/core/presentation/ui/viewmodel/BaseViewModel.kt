package com.exfarnanda1945.loremipsumgen.core.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exfarnanda1945.loremipsumgen.core.presentation.ui.event.UiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<T> : ViewModel() {
    private var _uiChannel = Channel<UiEvent>()
    val uiChannel = _uiChannel.receiveAsFlow()

    protected fun sendUiEvent(uiEvent: UiEvent) {
        viewModelScope.launch {
            _uiChannel.send(uiEvent)
        }
    }

    protected fun sendUiEvent(uiEvents: List<UiEvent>) {
        viewModelScope.launch {
            uiEvents.onEach {
                _uiChannel.send(it)
            }
        }
    }

    abstract fun onEvent(event: T)
}