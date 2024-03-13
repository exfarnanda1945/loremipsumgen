package com.exfarnanda1945.loremipsumgen.feat_welcome.di

import com.exfarnanda1945.loremipsumgen.feat_welcome.domain.repository.IWelcomeRepository
import com.exfarnanda1945.loremipsumgen.feat_welcome.domain.usecase.ReadWelcomeUseCase
import com.exfarnanda1945.loremipsumgen.feat_welcome.domain.usecase.SetWelcomeUseCase
import com.exfarnanda1945.loremipsumgen.feat_welcome.domain.usecase.WelcomeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object WelcomeUseCaseModule {
    @Provides
    fun provideReadWelcomeUseCase(repo: IWelcomeRepository): ReadWelcomeUseCase =
        ReadWelcomeUseCase(repo)

    @Provides
    fun provideSetWelcomeUseCase(repo: IWelcomeRepository): SetWelcomeUseCase =
        SetWelcomeUseCase(repo)

    @Provides
    fun provideWelcomeUseCase(
        read: ReadWelcomeUseCase,
        set: SetWelcomeUseCase
    ): WelcomeUseCase = WelcomeUseCase(read, set)
}