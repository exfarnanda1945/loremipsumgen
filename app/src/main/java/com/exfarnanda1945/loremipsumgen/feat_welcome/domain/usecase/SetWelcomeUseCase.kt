package com.exfarnanda1945.loremipsumgen.feat_welcome.domain.usecase

import com.exfarnanda1945.loremipsumgen.feat_welcome.domain.repository.IWelcomeRepository
import javax.inject.Inject

class SetWelcomeUseCase @Inject constructor(private val repo: IWelcomeRepository) {
    suspend operator fun invoke(value: Boolean) = repo.set(value)
}