package com.exfarnanda1945.loremipsumgen.feat_history.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.exfarnanda1945.loremipsumgen.feat_history.domain.models.GeneratorSetting

@Entity(
    tableName = "history_generator",
    indices = [Index(value = ["id"], unique = true)],
    foreignKeys = [ForeignKey(
        GeneratorSettingEntity::class,
        parentColumns = ["id"],
        childColumns = ["setting_id"]
    )]
)
data class HistoryGeneratorEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo("createdAt")
    val createdAt: Long,
    @ColumnInfo("result")
    val result: String,
    @ColumnInfo("setting_id")
    val setting: GeneratorSetting
)
