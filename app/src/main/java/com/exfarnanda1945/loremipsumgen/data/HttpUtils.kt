package com.exfarnanda1945.loremipsumgen.data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object HttpUtils {
    private const val BASE_URL = "https://loripsum.net/api/"

    private val client = OkHttpClient.Builder().build()

    private val gson = GsonBuilder().setLenient().create()

    private val retrofit by lazy {
        Retrofit.Builder().client(client).baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val generatorService: IGeneratorApi by lazy {
        retrofit.create(IGeneratorApi::class.java)
    }

}