package com.exfarnanda1945.loremipsumgen.feat_history.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "history_generator",
)
data class HistoryGeneratorEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val createdAt: Long,
    val result: String,
)
