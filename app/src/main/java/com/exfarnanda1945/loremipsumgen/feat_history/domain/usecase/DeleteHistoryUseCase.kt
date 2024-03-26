package com.exfarnanda1945.loremipsumgen.feat_history.domain.usecase

import com.exfarnanda1945.loremipsumgen.feat_history.domain.repository.IHistoryRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class DeleteHistoryUseCase @Inject constructor(
    private val repository: IHistoryRepository
) {
    suspend operator fun invoke(id: Int) = repository.delete(id)
}