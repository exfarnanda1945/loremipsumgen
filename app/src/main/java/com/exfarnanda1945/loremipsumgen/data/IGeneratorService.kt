package com.exfarnanda1945.loremipsumgen.data

import kotlinx.coroutines.flow.Flow

interface IGeneratorService {
    fun generate(url:String): Flow<Resource<String>>
}