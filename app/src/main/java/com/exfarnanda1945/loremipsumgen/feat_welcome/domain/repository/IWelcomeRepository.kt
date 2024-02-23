package com.exfarnanda1945.loremipsumgen.feat_welcome.domain.repository

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface IWelcomeRepository {
    suspend fun set(value: Boolean)
   suspend fun read(): Flow<Preferences>
}