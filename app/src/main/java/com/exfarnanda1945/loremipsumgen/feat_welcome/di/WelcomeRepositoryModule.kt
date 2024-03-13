package com.exfarnanda1945.loremipsumgen.feat_welcome.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.exfarnanda1945.loremipsumgen.feat_welcome.data.repository.WelcomeRepositoryImpl
import com.exfarnanda1945.loremipsumgen.feat_welcome.domain.repository.IWelcomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WelcomeRepositoryModule {
    @Provides
    @Singleton
    fun provideWelcomeRepository(ds: DataStore<Preferences>): IWelcomeRepository =
        WelcomeRepositoryImpl(ds)
}