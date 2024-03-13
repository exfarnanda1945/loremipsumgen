package com.exfarnanda1945.loremipsumgen.feat_result.di

import com.exfarnanda1945.loremipsumgen.feat_result.data.dao.IResultDao
import com.exfarnanda1945.loremipsumgen.feat_result.data.repository.ResultRepositoryImpl
import com.exfarnanda1945.loremipsumgen.feat_result.domain.repository.IResultRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ResultRepositoryModule {
    @Provides
    @Singleton
    fun provideResultRepositoryDao(dao: IResultDao): IResultRepository = ResultRepositoryImpl(dao)

}