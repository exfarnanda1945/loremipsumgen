package com.exfarnanda1945.loremipsumgen.feat_history.di

import com.exfarnanda1945.loremipsumgen.core.database.GeneratorDatabase
import com.exfarnanda1945.loremipsumgen.feat_history.data.dao.IGeneratorSettingDao
import com.exfarnanda1945.loremipsumgen.feat_history.data.dao.IHistoryGeneratorDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Singleton
    @Provides
    fun provideSettingDao(database: GeneratorDatabase): IGeneratorSettingDao = database.settingDao

    @Singleton
    @Provides
    fun provideHistoryDao(database: GeneratorDatabase): IHistoryGeneratorDao = database.historyDao
}