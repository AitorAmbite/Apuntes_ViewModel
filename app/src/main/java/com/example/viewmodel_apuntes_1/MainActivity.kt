package com.example.viewmodel_apuntes_1

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel_apuntes_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // aqui creamos la variable que tendra el binding
    private lateinit var binding : ActivityMainBinding
    // Podemos crear aqui tambien un lateinit del model y luego instanciarlo dentro del 
    // private lateinit var model : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val model = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        model.downloadAll()

        model.films.forEach {
            Log.d("prueba",it.name)
            binding.tvLista.append("${it.name} \n")
        }
    }


}
