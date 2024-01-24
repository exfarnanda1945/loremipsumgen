package com.exfarnanda1945.loremipsumgen.feat_history.domain.models

data class HistoryGenerator(
    val id: Int,
    val createdAt: String,
    val result: String,
    val setting: GeneratorSetting
)

