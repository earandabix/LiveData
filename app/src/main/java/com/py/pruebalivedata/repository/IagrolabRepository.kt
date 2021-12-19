package com.py.pruebalivedata.repository

import androidx.lifecycle.LiveData
import com.py.pruebalivedata.dao.ParcelaDao
import com.py.pruebalivedata.entities.Campo

class IagrolabRepository(private val parcelaDao: ParcelaDao) {

    fun getCampo(): LiveData<List<Campo>> {
        return parcelaDao.getCampo()
    }

    suspend fun addCampo(campo: Campo) {
        parcelaDao.addCampo(campo)
    }

}