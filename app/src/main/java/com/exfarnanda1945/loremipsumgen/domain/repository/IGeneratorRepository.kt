package com.exfarnanda1945.loremipsumgen.domain.repository

import com.exfarnanda1945.loremipsumgen.utils.Resource

interface IGeneratorRepository {
    fun generate(url:String): Resource<String>
}