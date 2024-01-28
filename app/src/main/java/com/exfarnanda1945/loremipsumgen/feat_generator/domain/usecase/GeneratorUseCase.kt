package com.exfarnanda1945.loremipsumgen.feat_generator.domain.usecase

import com.exfarnanda1945.loremipsumgen.feat_generator.domain.repository.IGeneratorRepository
import com.exfarnanda1945.loremipsumgen.core.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GeneratorUseCase @Inject constructor(private val repository: IGeneratorRepository) {
    suspend operator fun invoke(url: String): Flow<Resource<String>> = flow {
        if (url.isBlank() || url.isEmpty()) {
            emit(Resource.Failure("Url cannot be blank or empty"))
        }

        val result = repository.generate(url)

        emit(result)
    }.flowOn(Dispatchers.IO)
}