package com.exfarnanda1945.loremipsumgen.domain.usecase

import com.exfarnanda1945.loremipsumgen.domain.repository.IGeneratorRepository
import com.exfarnanda1945.loremipsumgen.utils.Resource

class GeneratorUseCase(private val repository: IGeneratorRepository) {
    operator fun invoke(url: String): Resource<String> {
        return repository.generate(url)
    }
}