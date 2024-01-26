package com.exfarnanda1945.loremipsumgen.feat_history.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.exfarnanda1945.loremipsumgen.feat_history.data.entities.HistoryAndSetting
import com.exfarnanda1945.loremipsumgen.feat_history.data.entities.HistoryGeneratorEntity

@Dao
interface IHistoryGeneratorDao {
    @Transaction
    @Insert
    suspend fun create(history: HistoryAndSetting):Long

    @Transaction
    @Delete
    suspend fun delete(id: Int)

    @Transaction
    @Query("SELECT * FROM history_generator WHERE id = :id")
    fun get(id: Int): HistoryAndSetting

    @Transaction
    @Query("SELECT * FROM history_generator")
    fun list(): List<HistoryAndSetting>
}