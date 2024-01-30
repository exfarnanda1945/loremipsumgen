package com.exfarnanda1945.loremipsumgen.feat_history.data.entities

import androidx.room.Embedded
import androidx.room.Relation
import com.exfarnanda1945.loremipsumgen.feat_history.domain.models.GeneratorSetting
import com.exfarnanda1945.loremipsumgen.feat_history.domain.models.HistoryGenerator

data class HistoryAndSetting(
    @Embedded
    val history: HistoryGeneratorEntity,
    @Relation(
        // refer to HistoryGeneratorEntity.id
        parentColumn = "id",
        // refer to GeneratorSettingEntity.historyId
        entityColumn = "history_id"
    )
    val setting: GeneratorSettingEntity
)

fun HistoryAndSetting.toModel(): HistoryGenerator {
    val history = this.history
    val setting = this.setting

    return HistoryGenerator(
        id = history.id,
        createdAt = history.createdAt,
        result = history.result,
        setting = GeneratorSetting(
            id = setting.id,
            isAllCaps = setting.isAllCaps,
            isBq = setting.isBq,
            isCode = setting.isCode,
            isDecorate = setting.isDecorate,
            isDl = setting.isDl,
            isHeaders = setting.isHeaders,
            isLink = setting.isLink,
            isOl = setting.isOl,
            isParagraphLengthShow = setting.isParagraphLengthShow,
            isPrudeVer = setting.isPrudeVer,
            isUl = setting.isUl,
            isReturnPlainText = setting.isReturnPlainText,
            numOfParagraphs = setting.numOfParagraphs,
            paragraphLength = setting.paragraphLength
        )
    )
}

fun HistoryGenerator.toEntity(): HistoryAndSetting {
    val setting = this.setting

    return HistoryAndSetting(
        history = HistoryGeneratorEntity(
            id = this.id,
            createdAt = this.createdAt,
            result = this.result
        ),
        setting = GeneratorSettingEntity(
            id = setting.id,
            isAllCaps = setting.isAllCaps,
            isBq = setting.isBq,
            isCode = setting.isCode,
            isDecorate = setting.isDecorate,
            isDl = setting.isDl,
            isHeaders = setting.isHeaders,
            isLink = setting.isLink,
            isOl = setting.isOl,
            isParagraphLengthShow = setting.isParagraphLengthShow,
            isPrudeVer = setting.isPrudeVer,
            isUl = setting.isUl,
            isReturnPlainText = setting.isReturnPlainText,
            numOfParagraphs = setting.numOfParagraphs,
            paragraphLength = setting.paragraphLength,
            historyId = this.id
        )
    )
}
