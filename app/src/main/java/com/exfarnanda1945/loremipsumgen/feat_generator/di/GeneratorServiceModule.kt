package com.exfarnanda1945.loremipsumgen.feat_generator.di

import com.exfarnanda1945.loremipsumgen.feat_generator.data.service.IGeneratorService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object GeneratorServiceModule {
    @Provides
    @ViewModelScoped
    fun provideGeneratorService(retrofit: Retrofit): IGeneratorService =
        retrofit.create(IGeneratorService::class.java)
}