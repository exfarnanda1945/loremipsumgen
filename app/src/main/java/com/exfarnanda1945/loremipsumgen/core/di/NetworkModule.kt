package com.exfarnanda1945.loremipsumgen.core.di

import com.exfarnanda1945.loremipsumgen.core.utils.Constant.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    private fun provideClient(): OkHttpClient =
        OkHttpClient.Builder().readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS).build()

    @Singleton
    @Provides
    private fun provideGson(): Gson = GsonBuilder().setLenient().create()

    @Singleton
    @Provides
    private fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit =
        Retrofit.Builder().client(client).baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
}