package com.exfarnanda1945.loremipsumgen.feat_history.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.exfarnanda1945.loremipsumgen.feat_history.domain.models.HistoryGenerator

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
    val setting: GeneratorSettingEntity
)

fun HistoryGeneratorEntity.toModel() = HistoryGenerator(
    id = this.id,
    createdAt = this.createdAt,
    result = this.result,
    setting = this.setting.toModel()
)

fun HistoryGenerator.toEntity() = HistoryGeneratorEntity(
    result = this.result,
    createdAt = this.createdAt,
    id = this.id,
    setting = this.setting.toEntity()
)

