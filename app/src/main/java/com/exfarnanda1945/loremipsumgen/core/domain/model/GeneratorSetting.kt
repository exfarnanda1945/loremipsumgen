package com.exfarnanda1945.loremipsumgen.core.domain.model

import com.exfarnanda1945.loremipsumgen.feat_generator.utils.ParagraphLengthEnum

interface GeneratorSetting {
    val numOfParagraphs: String
    val paragraphLength: ParagraphLengthEnum
    val isDecorate: Boolean
    val isLink: Boolean
    val isUl: Boolean
    val isOl: Boolean
    val isDl: Boolean
    val isBq: Boolean
    val isCode: Boolean
    val isHeaders: Boolean
    val isAllCaps: Boolean
    val isPrudeVer: Boolean
    val isReturnPlainText: Boolean
    val isParagraphLengthShow: Boolean
}
