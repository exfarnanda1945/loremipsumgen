package com.exfarnanda1945.loremipsumgen.feat_generator.presentation.screen.generator

import com.exfarnanda1945.loremipsumgen.core.domain.model.GeneratorSetting
import com.exfarnanda1945.loremipsumgen.feat_generator.utils.ParagraphLengthEnum

data class GeneratorState(
    override val numOfParagraphs: String = "1",
    override val paragraphLength: ParagraphLengthEnum = ParagraphLengthEnum.SHORT,
    override val isDecorate: Boolean = false,
    override val isLink: Boolean = false,
    override val isUl: Boolean = false,
    override val isOl: Boolean = false,
    override val isDl: Boolean = false,
    override val isBq: Boolean = false,
    override val isCode: Boolean = false,
    override val isHeaders: Boolean = false,
    override val isAllCaps: Boolean = false,
    override val isPrudeVer: Boolean = false,
    override val isReturnPlainText: Boolean = false,
    override val isParagraphLengthShow: Boolean = false
) : GeneratorSetting