package com.exfarnanda1945.loremipsumgen.feat_generator.di

import com.exfarnanda1945.loremipsumgen.feat_generator.domain.repository.IGeneratorRepository
import com.exfarnanda1945.loremipsumgen.feat_generator.domain.usecase.GeneratorUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGenUseCase(repo: IGeneratorRepository): GeneratorUseCase = GeneratorUseCase(repo)
}