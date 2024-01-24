package com.exfarnanda1945.loremipsumgen.feat_history.data.repository

import com.exfarnanda1945.loremipsumgen.core.utils.Resource
import com.exfarnanda1945.loremipsumgen.feat_history.data.dao.IGeneratorSettingDao
import com.exfarnanda1945.loremipsumgen.feat_history.data.dao.IHistoryGeneratorDao
import com.exfarnanda1945.loremipsumgen.feat_history.domain.models.HistoryGenerator
import com.exfarnanda1945.loremipsumgen.feat_history.domain.repository.IHistoryRepository
import javax.inject.Inject

class HistoryGeneratorRepositoryImpl @Inject constructor(
    private val settingDao: IGeneratorSettingDao,
    private val historyDao: IHistoryGeneratorDao
) : IHistoryRepository {
    override suspend fun insert(data: HistoryGenerator): Resource<Int> {
        TODO("Not yet implemented")
    }

    override suspend fun lists(): Resource<List<HistoryGenerator>> {
        TODO("Not yet implemented")
    }

    override suspend fun get(id: Int): Resource<HistoryGenerator> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: Int): Resource<Unit> {
        TODO("Not yet implemented")
    }
}