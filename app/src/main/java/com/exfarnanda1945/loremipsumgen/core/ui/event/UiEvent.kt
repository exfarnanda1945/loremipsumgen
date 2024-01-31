package com.exfarnanda1945.loremipsumgen.core.ui.event

sealed class UiEvent {
    class ShowSnackBar(msg:String):UiEvent()
    class ShowToast(msg:String):UiEvent()
    class NavigateTo(path:String):UiEvent()
}