package com.exfarnanda1945.loremipsumgen.feat_generator.di

import com.exfarnanda1945.loremipsumgen.feat_generator.data.repository.GeneratorRepositoryImpl
import com.exfarnanda1945.loremipsumgen.feat_generator.data.service.IGeneratorService
import com.exfarnanda1945.loremipsumgen.feat_generator.domain.repository.IGeneratorRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
object GeneratorRepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideGeneratorRepository(service: IGeneratorService): IGeneratorRepository =
        GeneratorRepositoryImpl(service)
}