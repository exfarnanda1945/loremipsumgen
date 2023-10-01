package com.exfarnanda1945.loremipsumgen.data

import retrofit2.http.GET
import retrofit2.http.Url

interface IGeneratorApi {
    @GET
    suspend fun generate(@Url url: String): String
}