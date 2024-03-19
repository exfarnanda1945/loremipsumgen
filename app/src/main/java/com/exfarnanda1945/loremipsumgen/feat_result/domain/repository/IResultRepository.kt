package com.exfarnanda1945.loremipsumgen.feat_result.domain.repository

import com.exfarnanda1945.loremipsumgen.core.domain.models.HistoryGenerator
import com.exfarnanda1945.loremipsumgen.core.utils.Resource

interface IResultRepository {
    suspend fun insert(data: HistoryGenerator): Resource<Long>
}