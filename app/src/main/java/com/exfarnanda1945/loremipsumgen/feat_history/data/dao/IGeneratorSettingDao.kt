package com.exfarnanda1945.loremipsumgen.feat_history.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.exfarnanda1945.loremipsumgen.feat_history.data.entities.GeneratorSettingEntity

@Dao
interface IGeneratorSettingDao {
    @Insert
    suspend fun create(setting: GeneratorSettingEntity):Int

    @Delete
    suspend fun delete(id: Int)

    @Query("SELECT * FROM generator_setting WHERE id = :id")
    fun get(id: Int): GeneratorSettingEntity
}