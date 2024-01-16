package com.exfarnanda1945.loremipsumgen.feat_generator.presentation

import com.exfarnanda1945.loremipsumgen.feat_generator.utils.ParagraphLengthEnum

sealed class GeneratorEvent {
    data class OnNumOfParagraphChange(val numOfParagraph:String) : GeneratorEvent()
    data class OnUseAllCapsSwitchChange(val useAllCaps: Boolean) : GeneratorEvent()
    data class OnPrudeVerSwitchChange(val prudeVer: Boolean) : GeneratorEvent()
    data class OnLinksSwitchChange(val link: Boolean) : GeneratorEvent()
    data class OnUnorderedListSwitchChange(val unorderedList: Boolean) : GeneratorEvent()
    data class OnOrderedListSwitchChange(val orderedList: Boolean) : GeneratorEvent()
    data class OnDescriptionListSwitchChange(val descriptionList: Boolean) : GeneratorEvent()
    data class OnBlockquoteSwitchChange(val blockquote: Boolean) : GeneratorEvent()
    data class OnCodeSwitchChange(val code: Boolean) : GeneratorEvent()
    data class OnHeadingSwitchChange(val heading: Boolean) : GeneratorEvent()
    data class OnBoldSwitchChange(val boldItalic: Boolean) : GeneratorEvent()
    data class OnParagraphLengthChange(val paragraphLength: ParagraphLengthEnum) : GeneratorEvent()
    data class OnReturnPlainTextChange(val returnPlainText:Boolean):GeneratorEvent()
    object OnGenerateBtnClick: GeneratorEvent()
    object OnParagraphLengthShow: GeneratorEvent()
    object  OnResetOption:GeneratorEvent()
}