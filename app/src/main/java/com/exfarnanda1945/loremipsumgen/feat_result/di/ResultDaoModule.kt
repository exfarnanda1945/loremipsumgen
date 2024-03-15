package com.exfarnanda1945.loremipsumgen.feat_result.di

import com.exfarnanda1945.loremipsumgen.core.data.database.GeneratorDatabase
import com.exfarnanda1945.loremipsumgen.feat_result.data.dao.IResultDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ResultDaoModule {

    @Provides
    @ViewModelScoped
    fun provideResultDao(db: GeneratorDatabase): IResultDao = db.resultDao
}