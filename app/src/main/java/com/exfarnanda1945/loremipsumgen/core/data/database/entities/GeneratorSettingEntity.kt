package com.exfarnanda1945.loremipsumgen.core.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.exfarnanda1945.loremipsumgen.core.utils.Constant.SETTING_TABLE_NAME
import com.exfarnanda1945.loremipsumgen.feat_generator.utils.ParagraphLengthEnum

@Entity(
    tableName = SETTING_TABLE_NAME,
)
data class GeneratorSettingEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val numOfParagraphs: String,
    val paragraphLength: ParagraphLengthEnum,
    val isDecorate: Boolean,
    val isLink: Boolean,
    val isUl: Boolean,
    val isOl: Boolean,
    val isDl: Boolean,
    val isBq: Boolean,
    val isCode: Boolean,
    val isHeaders: Boolean,
    val isAllCaps: Boolean,
    val isPrudeVer: Boolean,
    val isReturnPlainText: Boolean,
    val isParagraphLengthShow: Boolean,
    @ColumnInfo(name = "history_id")
    val historyId: Long
)
