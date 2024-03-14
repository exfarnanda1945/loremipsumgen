package com.exfarnanda1945.loremipsumgen.feat_generator.domain.usecase

import com.exfarnanda1945.loremipsumgen.core.utils.Resource
import com.exfarnanda1945.loremipsumgen.feat_generator.domain.repository.IGeneratorRepository
import com.exfarnanda1945.loremipsumgen.feat_generator.presentation.screen.generator.GeneratorState
import com.exfarnanda1945.loremipsumgen.feat_generator.utils.UrlParamGenerator
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GeneratorUseCase @Inject constructor(private val repository: IGeneratorRepository) {
    suspend operator fun invoke(option: GeneratorState): Resource<String> {

        if (option.numOfParagraphs.isEmpty() ||
            option.numOfParagraphs.isBlank()
        ) {
            return Resource.Failure("Number of paragraph not valid")
        }

        if (option.numOfParagraphs == "0") {
            return Resource.Failure("Number of paragraph cannot be 0")
        }

        if (option.numOfParagraphs.startsWith("-") || option.numOfParagraphs.startsWith(" ")) {
            return Resource.Failure("Number of paragraph cannot start with - and space")
        }

        val url = UrlParamGenerator.generate(option)

        if (url.isBlank() || url.isEmpty()) {
            return Resource.Failure("Url cannot be blank or empty")
        }

        return repository.generate(url)
    }
}