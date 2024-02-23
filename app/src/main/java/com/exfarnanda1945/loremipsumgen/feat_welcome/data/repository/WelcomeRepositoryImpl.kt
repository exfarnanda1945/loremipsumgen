package com.exfarnanda1945.loremipsumgen.feat_welcome.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.exfarnanda1945.loremipsumgen.core.utils.Constant.DS_WELCOME_USER
import com.exfarnanda1945.loremipsumgen.feat_welcome.domain.repository.IWelcomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WelcomeRepositoryImpl @Inject constructor(private val ds: DataStore<Preferences>) :
    IWelcomeRepository {

    private val welcomeKey = booleanPreferencesKey(DS_WELCOME_USER)

    override suspend fun set(value: Boolean) {
        ds.edit { preferences ->
            preferences[welcomeKey] = value
        }
    }

    override suspend fun read(): Flow<Preferences> {
        return ds.data
    }
}