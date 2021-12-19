package com.py.pruebalivedata.viewModel.vistaCaminito

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.py.pruebalivedata.database.IagrolabDatabase
import com.py.pruebalivedata.entities.Campo
import com.py.pruebalivedata.repository.IagrolabRepository


class VistaCaminito(application: Application) : ViewModel() {
    var campo: LiveData<List<Campo>>
    private val repository: IagrolabRepository

    init {
        val userDao = IagrolabDatabase.getDatabase(application).parcelaDao()
        repository = IagrolabRepository(userDao)
        campo = repository.getCampo()
    }

    suspend fun addCampo(campo: Campo) {
        repository.addCampo(campo)
    }

}