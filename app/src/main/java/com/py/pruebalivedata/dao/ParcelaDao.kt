package com.py.pruebalivedata.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.py.pruebalivedata.entities.Campo

@Dao
interface ParcelaDao {

    @Query("SELECT * FROM Campo")
    fun getCampo(): LiveData<List<Campo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCampo(campo: Campo)
}