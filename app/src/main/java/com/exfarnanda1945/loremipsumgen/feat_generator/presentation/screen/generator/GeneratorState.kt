package com.exfarnanda1945.loremipsumgen.feat_generator.presentation.screen.generator

import com.exfarnanda1945.loremipsumgen.feat_generator.utils.ParagraphLengthEnum

data class GeneratorState(
    val numOfParagraphs: String = "1",
    val paragraphLength: ParagraphLengthEnum = ParagraphLengthEnum.SHORT,
    val isDecorate: Boolean = false,
    val isLink: Boolean = false,
    val isUl: Boolean = false,
    val isOl: Boolean = false,
    val isDl: Boolean = false,
    val isBq: Boolean = false,
    val isCode: Boolean = false,
    val isHeaders: Boolean = false,
    val isAllCaps: Boolean = false,
    val isPrudeVer: Boolean = false,
    val isReturnPlainText: Boolean = false,
    val isParagraphLengthShow: Boolean = false
)