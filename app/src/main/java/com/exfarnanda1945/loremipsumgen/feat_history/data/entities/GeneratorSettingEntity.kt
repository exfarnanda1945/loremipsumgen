package com.exfarnanda1945.loremipsumgen.feat_history.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.exfarnanda1945.loremipsumgen.feat_generator.utils.ParagraphLengthEnum
import com.exfarnanda1945.loremipsumgen.feat_history.domain.models.GeneratorSetting

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

fun GeneratorSettingEntity.toModel() = GeneratorSetting(
    id = this.id,
    isAllCaps = this.isAllCaps,
    isBq = this.isBq,
    isCode = this.isCode,
    isDecorate = this.isDecorate,
    isDl = this.isDl,
    isHeaders = this.isHeaders,
    isLink = this.isLink,
    isOl = this.isOl,
    isParagraphLengthShow = this.isParagraphLengthShow,
    isPrudeVer = this.isPrudeVer,
    isReturnPlainText = this.isReturnPlainText,
    isUl = this.isUl,
    numOfParagraphs = this.numOfParagraphs,
    paragraphLength = this.paragraphLength
)

fun GeneratorSetting.toEntity() = GeneratorSettingEntity(
    id = this.id,
    numOfParagraphs = this.numOfParagraphs,
    paragraphLength = this.paragraphLength,
    isDecorate = this.isDecorate,
    isLink = this.isLink,
    isUl = this.isUl,
    isOl = this.isOl,
    isDl = this.isDl,
    isBq = this.isBq,
    isCode = this.isCode,
    isHeaders = this.isHeaders,
    isAllCaps = this.isAllCaps,
    isPrudeVer = this.isPrudeVer,
    isReturnPlainText = this.isReturnPlainText,
    isParagraphLengthShow = this.isParagraphLengthShow
)
