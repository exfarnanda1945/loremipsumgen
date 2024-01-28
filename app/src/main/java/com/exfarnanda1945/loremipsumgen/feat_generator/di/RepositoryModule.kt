package com.exfarnanda1945.loremipsumgen.feat_generator.di

import com.exfarnanda1945.loremipsumgen.feat_generator.data.repository.GeneratorRepositoryImpl
import com.exfarnanda1945.loremipsumgen.feat_generator.data.service.IGeneratorService
import com.exfarnanda1945.loremipsumgen.feat_generator.domain.repository.IGeneratorRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideGeneratorRepository(service: IGeneratorService): IGeneratorRepository =
        GeneratorRepositoryImpl(service)
}