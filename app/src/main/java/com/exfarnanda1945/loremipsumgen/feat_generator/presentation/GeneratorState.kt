package com.exfarnanda1945.loremipsumgen.feat_generator.presentation

import com.exfarnanda1945.loremipsumgen.feat_generator.utils.ParagraphLengthEnum

data class GeneratorState(
    val numOfParagraphs: String = "1",
    val paragraphLength: ParagraphLengthEnum = ParagraphLengthEnum.SHORT,
    val isDecorate:Boolean = false,
    val addLink:Boolean = false,
    val addUl:Boolean = false,
    val addOl:Boolean = false,
    val addDl:Boolean = false,
    val addBq:Boolean = false,
    val addCode:Boolean = false,
    val addHeaders:Boolean = false,
    val addAllCaps:Boolean = false,
    val prudeVer:Boolean = false,
    val returnPlainText:Boolean = false,
    val isParagraphLengthShow: Boolean = false,
)