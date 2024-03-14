package com.exfarnanda1945.loremipsumgen.feat_result.di

import com.exfarnanda1945.loremipsumgen.feat_result.domain.repository.IResultRepository
import com.exfarnanda1945.loremipsumgen.feat_result.domain.usecase.ResultUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ResultUseCaseModule {
    @ViewModelScoped
    @Provides
    fun provideResultUseCase(repository: IResultRepository): ResultUseCase =
        ResultUseCase(repository)
}