package com.exfarnanda1945.loremipsumgen.domain

import com.exfarnanda1945.loremipsumgen.data.IGeneratorApi
import com.exfarnanda1945.loremipsumgen.data.IGeneratorService
import com.exfarnanda1945.loremipsumgen.data.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GeneratorService(private val api: IGeneratorApi) : IGeneratorService {
    override fun generate(url: String): Flow<Resource<String>> = flow {
        emit(Resource.Loading())
        val response = api.generate(url)
        emit(Resource.Success(response))
    }.catch {
        emit(Resource.Error(it.localizedMessage!!))
    }.flowOn(Dispatchers.IO)

}