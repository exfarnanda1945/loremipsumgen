package com.exfarnanda1945.loremipsumgen.feat_generator.utils

import com.exfarnanda1945.loremipsumgen.feat_generator.presentation.screen.generator.GeneratorState

object UrlParamGenerator {

    fun generate(state: GeneratorState): String {
        var url = ""

        if (state.numOfParagraphs.toInt() != 0) {
            url += state.numOfParagraphs
        }

        url += when (state.paragraphLength) {
            ParagraphLengthEnum.SHORT -> "/${ParagraphLengthEnum.SHORT.value}"
            ParagraphLengthEnum.MEDIUM -> "/${ParagraphLengthEnum.MEDIUM.value}"
            ParagraphLengthEnum.LONG -> "/${ParagraphLengthEnum.LONG.value}"
        }

        if (state.isDecorate) {
            url += "/decorate"
        }

        if (state.isLink) {
            url += "/link"
        }

        if (state.isOl) {
            url += "/ol"
        }

        if (state.isDl) {
            url += "/dl"
        }

        if (state.isBq) {
            url += "/bq"
        }

        if (state.isCode) {
            url += "/code"
        }

        if (state.isHeaders) {
            url += "/headers"
        }

        if (state.isAllCaps) {
            url += "/allcaps"
        }

        if (state.isPrudeVer) {
            url += "/prude"
        }

        if (state.isReturnPlainText) {
            url += "/plaintext"
        }

        return url
    }
}