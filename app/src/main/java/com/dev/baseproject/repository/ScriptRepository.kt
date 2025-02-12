package com.dev.baseproject.repository

import com.dev.baseproject.data.dao.ClickerDao
import com.dev.baseproject.data.entity.ClickerEntity
import javax.inject.Inject
import javax.inject.Singleton
@Singleton
class ScriptRepository @Inject constructor(
    private val clickerDao: ClickerDao
) {
    fun insertNewScript(listClick: List<ClickerEntity>) {
        for (item in listClick) {
            clickerDao.insert(item)
        }
    }

    companion object {
        const val TAG = "ScriptRepository"
    }
}