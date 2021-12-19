package com.bix.iaogrolab.viewModel.vistaCaminito

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.py.pruebalivedata.viewModel.vistaCaminito.VistaCaminito

@Suppress("UNCHECKED_CAST")
class VistaCaminitoModelFactory(application: Application) : AndroidViewModel(application),
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return VistaCaminito(application = getApplication()) as T
    }
}