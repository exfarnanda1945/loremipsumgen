package com.exfarnanda1945.loremipsumgen.feat_generator.di

import com.exfarnanda1945.loremipsumgen.feat_generator.domain.repository.IGeneratorRepository
import com.exfarnanda1945.loremipsumgen.feat_generator.domain.usecase.GeneratorUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object GeneratorUseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideGenUseCase(repo: IGeneratorRepository): GeneratorUseCase = GeneratorUseCase(repo)
}