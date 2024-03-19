package com.exfarnanda1945.loremipsumgen.feat_history.data.repository

import com.exfarnanda1945.loremipsumgen.core.domain.models.HistoryGenerator
import com.exfarnanda1945.loremipsumgen.core.utils.JsonUtils
import com.exfarnanda1945.loremipsumgen.core.utils.Resource
import com.exfarnanda1945.loremipsumgen.feat_history.data.dao.IHistoryGeneratorDao
import com.exfarnanda1945.loremipsumgen.feat_history.domain.repository.IHistoryRepository
import com.exfarnanda1945.loremipsumgen.feat_history.util.SafeCall
import javax.inject.Inject

class HistoryGeneratorRepositoryImpl @Inject constructor(
    private val historyDao: IHistoryGeneratorDao,
    private val jsonUtils: JsonUtils
) : IHistoryRepository {
    override suspend fun lists(): Resource<List<HistoryGenerator>> = SafeCall {
        val list = historyDao.list()
        list.map {
            HistoryGenerator(
                id = it.id,
                createdAt = it.createdAt,
                result = it.result,
                setting = jsonUtils.fromJson(it.setting)
            )
        }
    }

    override suspend fun get(id: Int): Resource<HistoryGenerator> = SafeCall {
        val get = historyDao.get(id)
        HistoryGenerator(
            id = get.id,
            createdAt = get.createdAt,
            result = get.result,
            setting = jsonUtils.fromJson(get.setting)
        )
    }

    override suspend fun delete(id: Int): Resource<Unit> = SafeCall {
        historyDao.delete(id)
    }
}