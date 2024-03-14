package com.exfarnanda1945.loremipsumgen.feat_generator.data.repository

import com.exfarnanda1945.loremipsumgen.core.utils.Resource
import com.exfarnanda1945.loremipsumgen.feat_generator.data.service.IGeneratorService
import com.exfarnanda1945.loremipsumgen.feat_generator.domain.repository.IGeneratorRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GeneratorRepositoryImpl @Inject constructor(private val generatorService: IGeneratorService) :
    IGeneratorRepository {
    override suspend fun generate(url: String): Resource<String> {
        try {
            val response = generatorService.generate(url)
            if (response.code() != 200) {
                return Resource.Failure(response.message())
            }

            val result = response.body()!!
            return Resource.Success(result)
        } catch (e: Exception) {
            return Resource.Failure(e.localizedMessage?.toString() ?: "Unknown Error")
        }
    }
}