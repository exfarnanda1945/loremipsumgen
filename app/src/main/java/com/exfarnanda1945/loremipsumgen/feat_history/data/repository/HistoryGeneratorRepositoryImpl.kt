package com.exfarnanda1945.loremipsumgen.feat_history.data.repository

import com.exfarnanda1945.loremipsumgen.core.utils.Resource
import com.exfarnanda1945.loremipsumgen.feat_history.data.dao.IHistoryGeneratorDao
import com.exfarnanda1945.loremipsumgen.feat_history.data.entities.toEntity
import com.exfarnanda1945.loremipsumgen.feat_history.data.entities.toModel
import com.exfarnanda1945.loremipsumgen.feat_history.domain.models.HistoryGenerator
import com.exfarnanda1945.loremipsumgen.feat_history.domain.repository.IHistoryRepository
import com.exfarnanda1945.loremipsumgen.feat_history.util.SafeCall
import javax.inject.Inject

class HistoryGeneratorRepositoryImpl @Inject constructor(
    private val historyDao: IHistoryGeneratorDao
) : IHistoryRepository {
    override suspend fun insert(data: HistoryGenerator): Resource<Long> = SafeCall {
        historyDao.create(data.toEntity())
    }

    override suspend fun lists(): Resource<List<HistoryGenerator>> = SafeCall {
        val list = historyDao.list()
        list.map { it.toModel() }
    }

    override suspend fun get(id: Int): Resource<HistoryGenerator> = SafeCall(call = {
        val get = historyDao.get(id)
        get.toModel()
    })

    override suspend fun delete(id: Int): Resource<Unit> = SafeCall {
        historyDao.delete(id)
    }
}