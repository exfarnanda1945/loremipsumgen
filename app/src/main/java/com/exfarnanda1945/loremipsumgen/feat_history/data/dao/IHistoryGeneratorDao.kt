package com.exfarnanda1945.loremipsumgen.feat_history.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.exfarnanda1945.loremipsumgen.feat_history.data.entities.HistoryGeneratorEntity

@Dao
interface IHistoryGeneratorDao {
    @Insert
    suspend fun create(history: HistoryGeneratorEntity): Int

    @Delete
    suspend fun delete(id: Int)

    @Query("SELECT * FROM history_generator WHERE id = :id")
    fun get(id: Int): HistoryGeneratorEntity
}