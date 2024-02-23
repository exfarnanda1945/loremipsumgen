package com.exfarnanda1945.loremipsumgen.feat_welcome.domain.usecase

import androidx.datastore.preferences.core.Preferences
import com.exfarnanda1945.loremipsumgen.feat_welcome.domain.repository.IWelcomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadWelcomeUseCase @Inject constructor(private val repo: IWelcomeRepository) {
    suspend operator fun invoke(): Flow<Preferences> = repo.read()
}