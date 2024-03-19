package com.exfarnanda1945.loremipsumgen.feat_history.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.exfarnanda1945.loremipsumgen.core.data.database.entities.HistoryGeneratorEntity
import com.exfarnanda1945.loremipsumgen.core.utils.Constant.HISTORY_TABLE_NAME

@Dao
interface IHistoryGeneratorDao {

    @Transaction
    @Query("DELETE FROM $HISTORY_TABLE_NAME WHERE id = :id")
    suspend fun delete(id: Int)

    @Transaction
    @Query("SELECT * FROM $HISTORY_TABLE_NAME WHERE id = :id")
    fun get(id: Int): HistoryGeneratorEntity

    @Transaction
    @Query("SELECT * FROM $HISTORY_TABLE_NAME")
    fun list(): List<HistoryGeneratorEntity>
}