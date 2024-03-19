package com.exfarnanda1945.loremipsumgen.core.presentation.ui.event

sealed class UiEvent {
    class ShowSnackBar(val msg: String) : UiEvent()
    class ShowToast(val msg: String) : UiEvent()
    class NavigateTo(val path: String) : UiEvent()
    object NavigateBack : UiEvent()
    class ShowLoading(val isLoading: Boolean) : UiEvent()
}