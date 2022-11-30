package com.example.b_sket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val retrunButton = findViewById<Button>(R.id.retrun_button)
        retrunButton.setOnClickListener {
            finish()
        }

    }
}