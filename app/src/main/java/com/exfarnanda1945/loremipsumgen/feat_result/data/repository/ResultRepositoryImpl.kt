package com.exfarnanda1945.loremipsumgen.feat_result.data.repository

import com.exfarnanda1945.loremipsumgen.core.data.database.entities.HistoryGeneratorEntity
import com.exfarnanda1945.loremipsumgen.core.domain.models.HistoryGenerator
import com.exfarnanda1945.loremipsumgen.core.utils.JsonUtils
import com.exfarnanda1945.loremipsumgen.core.utils.Resource
import com.exfarnanda1945.loremipsumgen.core.utils.SafeCall
import com.exfarnanda1945.loremipsumgen.feat_result.data.dao.IResultDao
import com.exfarnanda1945.loremipsumgen.feat_result.domain.repository.IResultRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class ResultRepositoryImpl @Inject constructor(
    private val resultDao: IResultDao,
    private val jsonUtils: JsonUtils,
) :
    IResultRepository {

    override suspend fun insert(data: HistoryGenerator): Resource<Long> = SafeCall {
        resultDao.create(
            HistoryGeneratorEntity(
                id = data.id,
                result = data.result,
                createdAt = data.createdAt,
                setting = jsonUtils.toJson(data.setting)
            )
        )
    }
}