package com.exfarnanda1945.loremipsumgen.feat_generator.domain.usecase

import com.exfarnanda1945.loremipsumgen.feat_generator.domain.repository.IGeneratorRepository
import com.exfarnanda1945.loremipsumgen.core.utils.Resource
import javax.inject.Inject

class GeneratorUseCase @Inject constructor(private val repository: IGeneratorRepository) {
    suspend operator fun invoke(url: String): Resource<String> {
        if (url.isBlank() || url.isEmpty()) {
            return Resource.failure("Url cannot be blank or empty")
        }

        return repository.generate(url)
    }
}