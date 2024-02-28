package com.exfarnanda1945.loremipsumgen.core.ui.event

sealed class UiEvent {
    class ShowSnackBar(val msg: String) : UiEvent()
    class ShowToast(val msg: String) : UiEvent()
    class NavigateTo( val data: String? = null) : UiEvent()
    class ShowLoading(val isLoading: Boolean) : UiEvent()
}