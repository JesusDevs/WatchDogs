package com.example.apppro.base

import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager

import androidx.appcompat.app.AppCompatActivity


import com.example.watchdogs.databinding.ActivityMainBinding
/* actividad base para crear metodos extendidos (Extension function)
* se extiende de AppCompactActivity y permite crear plantillas de trabajo reduciendo codigo redundante an cada activity
* */

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //pantalla sin barra de notificaciones
        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}