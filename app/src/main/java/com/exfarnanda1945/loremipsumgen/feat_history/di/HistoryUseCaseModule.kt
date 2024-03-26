package com.exfarnanda1945.loremipsumgen.feat_history.di

import com.exfarnanda1945.loremipsumgen.feat_history.domain.repository.IHistoryRepository
import com.exfarnanda1945.loremipsumgen.feat_history.domain.usecase.DeleteHistoryUseCase
import com.exfarnanda1945.loremipsumgen.feat_history.domain.usecase.GetHistoryUseCase
import com.exfarnanda1945.loremipsumgen.feat_history.domain.usecase.HistoryUseCase
import com.exfarnanda1945.loremipsumgen.feat_history.domain.usecase.ListHistoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelScoped::class)
object HistoryUseCaseModule {

    @ViewModelScoped
    @Provides
    fun provideDeleteHistoryUseCase(
        repository: IHistoryRepository
    ) = DeleteHistoryUseCase(repository)

    @ViewModelScoped
    @Provides
    fun provideGetHistoryUseCase(
        repository: IHistoryRepository
    ) = GetHistoryUseCase(repository)

    @ViewModelScoped
    @Provides
    fun provideListHistoryUseCase(
        repository: IHistoryRepository
    ) = ListHistoryUseCase(repository)

    @ViewModelScoped
    @Provides
    fun provideHistoryUseCase(
        get: GetHistoryUseCase,
        list: ListHistoryUseCase,
        delete: DeleteHistoryUseCase
    ) = HistoryUseCase(delete = delete, get = get, list = list)
}