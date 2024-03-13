package com.exfarnanda1945.loremipsumgen.feat_result.data.dao

import androidx.room.Insert
import androidx.room.Transaction
import com.exfarnanda1945.loremipsumgen.core.database.entities.HistoryAndSetting

interface IResultDao {
    @Transaction
    @Insert
    suspend fun create(history: HistoryAndSetting): Long

}