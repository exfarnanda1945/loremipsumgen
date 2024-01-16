package com.exfarnanda1945.loremipsumgen.feat_generator.domain.repository

import com.exfarnanda1945.loremipsumgen.core.utils.Resource

interface IGeneratorRepository {
    suspend fun generate(url:String): Resource<String>
}