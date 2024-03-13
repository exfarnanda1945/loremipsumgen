package com.exfarnanda1945.loremipsumgen.feat_result.data.repository

import com.exfarnanda1945.loremipsumgen.core.database.entities.toEntity
import com.exfarnanda1945.loremipsumgen.core.utils.Resource
import com.exfarnanda1945.loremipsumgen.feat_history.domain.models.HistoryGenerator
import com.exfarnanda1945.loremipsumgen.feat_history.util.SafeCall
import com.exfarnanda1945.loremipsumgen.feat_result.data.dao.IResultDao
import com.exfarnanda1945.loremipsumgen.feat_result.domain.repository.IResultRepository
import javax.inject.Inject

class ResultRepositoryImpl @Inject constructor(private val resultDao: IResultDao) :
    IResultRepository {
    override suspend fun insert(data: HistoryGenerator): Resource<Long> = SafeCall {
        resultDao.create(data.toEntity())
    }
}