package com.exfarnanda1945.loremipsumgen.feat_history.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.exfarnanda1945.loremipsumgen.feat_generator.utils.ParagraphLengthEnum

@Entity(
    tableName = "generator_setting",
    indices = [Index(value = ["id"], unique = true)],
)
data class GeneratorSettingEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo("numOfParagraphs")
    val numOfParagraphs: String,
    @ColumnInfo("paragraphLength")
    val paragraphLength: ParagraphLengthEnum,
    @ColumnInfo("isDecorate")
    val isDecorate: Boolean,
    @ColumnInfo("isLink")
    val isLink: Boolean,
    @ColumnInfo("isUl")
    val isUl: Boolean,
    @ColumnInfo("isOl")
    val isOl: Boolean,
    @ColumnInfo("isDl")
    val isDl: Boolean,
    @ColumnInfo("isBq")
    val isBq: Boolean,
    @ColumnInfo("isCode")
    val isCode: Boolean,
    @ColumnInfo("isHeaders")
    val isHeaders: Boolean,
    @ColumnInfo("isAllCaps")
    val isAllCaps: Boolean,
    @ColumnInfo("isPrudeVer")
    val isPrudeVer: Boolean,
    @ColumnInfo("isReturnPlainText")
    val isReturnPlainText: Boolean,
    @ColumnInfo("isParagraphLengthShow")
    val isParagraphLengthShow: Boolean
)
