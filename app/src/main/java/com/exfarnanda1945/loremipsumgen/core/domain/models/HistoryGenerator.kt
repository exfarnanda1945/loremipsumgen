package com.exfarnanda1945.loremipsumgen.core.domain.models

data class HistoryGenerator(
    val id: Long= 0,
    val createdAt: Long,
    val result: String,
    val setting: GeneratorSetting
)

