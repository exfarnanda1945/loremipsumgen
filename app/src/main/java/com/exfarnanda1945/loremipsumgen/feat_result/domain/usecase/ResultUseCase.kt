package com.exfarnanda1945.loremipsumgen.feat_result.domain.usecase

import com.exfarnanda1945.loremipsumgen.core.utils.Resource
import com.exfarnanda1945.loremipsumgen.feat_history.domain.models.HistoryGenerator
import com.exfarnanda1945.loremipsumgen.feat_result.domain.repository.IResultRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class ResultUseCase @Inject constructor(private val resultRepository: IResultRepository) {
    suspend operator fun invoke(data: HistoryGenerator): Resource<Long> {
        return resultRepository.insert(data)
    }
}