package com.exfarnanda1945.loremipsumgen.feat_history.domain.usecase

import com.exfarnanda1945.loremipsumgen.core.domain.models.HistoryGenerator
import com.exfarnanda1945.loremipsumgen.core.utils.Resource
import com.exfarnanda1945.loremipsumgen.feat_history.domain.repository.IHistoryRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetHistoryUseCase @Inject constructor(
    private val repository: IHistoryRepository
) {
    operator fun invoke(): Resource<List<HistoryGenerator>> = repository.lists()
}