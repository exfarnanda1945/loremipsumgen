package com.exfarnanda1945.loremipsumgen.feat_history.domain.usecase

data class HistoryUseCase(
    val delete: DeleteHistoryUseCase,
    val get: GetHistoryUseCase,
    val list: ListHistoryUseCase
)