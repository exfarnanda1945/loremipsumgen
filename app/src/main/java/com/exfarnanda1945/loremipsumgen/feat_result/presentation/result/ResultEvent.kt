package com.exfarnanda1945.loremipsumgen.feat_result.presentation.result

sealed class ResultEvent {
    data class OnCopyClipboard(val result:String) : ResultEvent()
    data class OnSaveResult(val result: String, val settings: String) : ResultEvent()
}