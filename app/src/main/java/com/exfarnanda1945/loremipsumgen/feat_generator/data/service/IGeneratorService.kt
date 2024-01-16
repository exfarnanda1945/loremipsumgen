package com.exfarnanda1945.loremipsumgen.feat_generator.data.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface IGeneratorService {
    @GET
    suspend fun generate(@Url url: String): Response<String>
}