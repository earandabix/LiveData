package com.py.pruebalivedata

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bix.iaogrolab.viewModel.vistaCaminito.VistaCaminitoModelFactory
import com.py.pruebalivedata.databinding.ActivityMainBinding
import com.py.pruebalivedata.entities.Campo
import com.py.pruebalivedata.viewModel.vistaCaminito.VistaCaminito
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mUserViewModelCaminito: VistaCaminito

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        inicializacionViewModels()
        test()
        binding.btnGuardar.setOnClickListener {
            val nombre = binding.etNombre.text
            if (!nombre.isNullOrEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    val campo = Campo(0, nombre.toString())
                    mUserViewModelCaminito.addCampo(campo)
                }
            } else {
                Toast.makeText(this, "Campo vacio", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun inicializacionViewModels() {
        val viewModelFactoryCaminito = VistaCaminitoModelFactory(application)
        mUserViewModelCaminito =
            ViewModelProvider(this, viewModelFactoryCaminito).get(VistaCaminito::class.java)
    }

    private fun test() {
        val campo = mUserViewModelCaminito.campo
        campo.observe(this, {
            Log.i("pruebas", "mira: $it")
        })
    }
}