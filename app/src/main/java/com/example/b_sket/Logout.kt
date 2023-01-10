package com.example.b_sket

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Logout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.logout)

        val no = findViewById<Button>(R.id.no)
        no.setOnClickListener {
            finish()
        }
    }
}