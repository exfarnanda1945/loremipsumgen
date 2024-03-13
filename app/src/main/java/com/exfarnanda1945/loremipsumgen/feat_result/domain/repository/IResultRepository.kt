package com.exfarnanda1945.loremipsumgen.feat_result.domain.repository

import com.exfarnanda1945.loremipsumgen.core.utils.Resource
import com.exfarnanda1945.loremipsumgen.feat_history.domain.models.HistoryGenerator

interface IResultRepository {
    suspend fun insert(data: HistoryGenerator): Resource<Long>
}