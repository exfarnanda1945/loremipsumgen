package com.exfarnanda1945.loremipsumgen.feat_history.di

import com.exfarnanda1945.loremipsumgen.core.data.database.GeneratorDatabase
import com.exfarnanda1945.loremipsumgen.feat_history.data.dao.IHistoryGeneratorDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HistoryDaoModule {
    @Singleton
    @Provides
    fun provideHistoryDao(database: GeneratorDatabase): IHistoryGeneratorDao = database.historyDao
}