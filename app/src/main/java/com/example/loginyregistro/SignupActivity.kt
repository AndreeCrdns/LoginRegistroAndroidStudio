package com.example.loginyregistro

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginyregistro.databinding.ActivitySignupBinding
import android.content.Intent

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var database: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = DatabaseHelper(this)
        binding.signupButton.setOnClickListener{
            val signupUsername = binding.signupEmail.text.toString()
            val signupPassword = binding.signupPassword.text.toString()
            singupDatabase(signupUsername, signupPassword)
        }

        binding.loginRedirectText.setOnClickListener{
            val intent = Intent(this, LoginActivity:: class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun singupDatabase(username : String, password : String){
        val insertedRowId = database.insertUser(username, password)
        if(insertedRowId != -1L){
            Toast.makeText(this, "Registro Hecho", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }else {
            Toast.makeText(this, "Registro Fallido", Toast.LENGTH_SHORT).show()
        }
    }
}