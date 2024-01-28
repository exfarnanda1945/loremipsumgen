package com.exfarnanda1945.loremipsumgen.feat_generator.presentation.screen.generator

import com.exfarnanda1945.loremipsumgen.feat_generator.utils.ParagraphLengthEnum

sealed class GeneratorEvent {
    data class OnNumOfParagraphChange(val numOfParagraph: String) : GeneratorEvent()
    data class OnUseAllCapsChecked(val useAllCaps: Boolean) : GeneratorEvent()
    data class OnPrudeVerChecked(val prudeVer: Boolean) : GeneratorEvent()
    data class OnLinksChecked(val link: Boolean) : GeneratorEvent()
    data class OnUnorderedListChecked(val unorderedList: Boolean) : GeneratorEvent()
    data class OnOrderedListChecked(val orderedList: Boolean) : GeneratorEvent()
    data class OnDescriptionListChecked(val descriptionList: Boolean) : GeneratorEvent()
    data class OnBlockquoteChecked(val blockquote: Boolean) : GeneratorEvent()
    data class OnCodeChecked(val code: Boolean) : GeneratorEvent()
    data class OnHeadingChecked(val heading: Boolean) : GeneratorEvent()
    data class OnBoldChecked(val boldItalic: Boolean) : GeneratorEvent()
    data class OnParagraphLengthChange(val paragraphLength: ParagraphLengthEnum) : GeneratorEvent()
    data class OnReturnPlainTextChange(val returnPlainText: Boolean) : GeneratorEvent()
    object OnGenerateBtnClick : GeneratorEvent()
    object OnParagraphLengthShow : GeneratorEvent()
    object OnResetOption : GeneratorEvent()
}