package com.example.loginyregistro

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Aquí creas un Intent para abrir la actividad LoginActivity
        val intent = Intent(
            this,
            LoginActivity::class.java
        )
        startActivity(intent)
    }
}

