package com.exfarnanda1945.loremipsumgen.feat_history.domain.repository

import com.exfarnanda1945.loremipsumgen.core.domain.models.HistoryGenerator
import com.exfarnanda1945.loremipsumgen.core.utils.Resource

interface IHistoryRepository {
    fun lists():Resource<List<HistoryGenerator>>
    fun get(id:Int):Resource<HistoryGenerator>
    suspend fun delete(id:Int):Resource<Unit>
}