package com.example.b_sket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val loginbutton = findViewById<Button>(R.id.button)
        loginbutton.setOnClickListener {
            val intent = Intent(this, logingo::class.java)
            startActivity(intent)
        }

        val returnButton = findViewById<Button>(R.id.return_button)
        returnButton.setOnClickListener {
            finish()
        }
    }
}