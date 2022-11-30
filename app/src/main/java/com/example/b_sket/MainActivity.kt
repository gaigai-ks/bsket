package com.example.b_sket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.top)

        val loginButton = findViewById<Button>(R.id.LoginButton)
        loginButton.setOnClickListener{
            val intent = Intent(this,LoginActivity ::class.java)
            startActivity(intent)
        }
    }

}