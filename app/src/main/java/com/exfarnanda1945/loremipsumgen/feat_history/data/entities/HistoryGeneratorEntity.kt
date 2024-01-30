package com.exfarnanda1945.loremipsumgen.feat_history.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.exfarnanda1945.loremipsumgen.core.utils.Constant.HISTORY_TABLE_NAME

@Entity(
    tableName = HISTORY_TABLE_NAME,
)
data class HistoryGeneratorEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val createdAt: Long,
    val result: String,
)
