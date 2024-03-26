package com.exfarnanda1945.loremipsumgen.feat_history.di

import com.exfarnanda1945.loremipsumgen.core.utils.JsonUtils
import com.exfarnanda1945.loremipsumgen.feat_history.data.dao.IHistoryGeneratorDao
import com.exfarnanda1945.loremipsumgen.feat_history.data.repository.HistoryGeneratorRepositoryImpl
import com.exfarnanda1945.loremipsumgen.feat_history.domain.repository.IHistoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object HistoryRepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideHistoryRepository(
        dao: IHistoryGeneratorDao,
        jsonUtils: JsonUtils
    ): IHistoryRepository = HistoryGeneratorRepositoryImpl(dao, jsonUtils)
}