package com.exfarnanda1945.loremipsumgen.feat_history.domain.models

data class HistoryGenerator(
    val id: Long,
    val createdAt: Long,
    val result: String,
    val setting: GeneratorSetting
)

