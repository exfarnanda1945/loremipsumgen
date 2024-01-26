package com.exfarnanda1945.loremipsumgen.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.exfarnanda1945.loremipsumgen.feat_history.data.dao.IHistoryGeneratorDao
import com.exfarnanda1945.loremipsumgen.feat_history.data.entities.GeneratorSettingEntity
import com.exfarnanda1945.loremipsumgen.feat_history.data.entities.HistoryGeneratorEntity

@Database(
    entities = [GeneratorSettingEntity::class, HistoryGeneratorEntity::class],
    version = 1,
    exportSchema = false
)
abstract class GeneratorDatabase : RoomDatabase() {
    abstract val historyDao: IHistoryGeneratorDao
}