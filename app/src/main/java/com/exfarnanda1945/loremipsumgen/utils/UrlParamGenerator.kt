package com.exfarnanda1945.loremipsumgen.utils

import com.exfarnanda1945.loremipsumgen.presentation.generator.GeneratorState

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

        if (state.addLink) {
            url += "/link"
        }

        if (state.addOl) {
            url += "/ol"
        }

        if (state.addDl) {
            url += "/dl"
        }

        if (state.addBq) {
            url += "/bq"
        }

        if (state.addCode) {
            url += "/code"
        }

        if (state.addHeaders) {
            url += "/headers"
        }

        if (state.addAllCaps) {
            url += "/allcaps"
        }

        if (state.prudeVer) {
            url += "/prude"
        }

        if (state.returnPlainText) {
            url += "/plaintext"
        }

        return url
    }
}