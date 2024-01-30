package com.exfarnanda1945.loremipsumgen.core.di

import android.content.Context
import androidx.room.Room
import com.exfarnanda1945.loremipsumgen.core.database.GeneratorDatabase
import com.exfarnanda1945.loremipsumgen.core.utils.Constant.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): GeneratorDatabase =
        Room.databaseBuilder(context, GeneratorDatabase::class.java, DATABASE_NAME)
            .build()
}