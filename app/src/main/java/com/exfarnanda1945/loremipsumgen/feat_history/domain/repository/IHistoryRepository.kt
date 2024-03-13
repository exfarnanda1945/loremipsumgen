package com.exfarnanda1945.loremipsumgen.feat_history.domain.repository

import com.exfarnanda1945.loremipsumgen.core.utils.Resource
import com.exfarnanda1945.loremipsumgen.feat_history.domain.models.HistoryGenerator

interface IHistoryRepository {
    suspend fun lists():Resource<List<HistoryGenerator>>
    suspend fun get(id:Int):Resource<HistoryGenerator>
    suspend fun delete(id:Int):Resource<Unit>
}