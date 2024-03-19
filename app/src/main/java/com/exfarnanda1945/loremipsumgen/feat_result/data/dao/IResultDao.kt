package com.exfarnanda1945.loremipsumgen.feat_result.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Transaction
import com.exfarnanda1945.loremipsumgen.core.data.database.entities.HistoryGeneratorEntity

@Dao
interface IResultDao {
    @Transaction
    @Insert
    suspend fun create(history: HistoryGeneratorEntity): Long

}