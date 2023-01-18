package com.example.b_sket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class logingo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val syousai = findViewById<Button>(R.id.syousai)
        syousai.setOnClickListener {
            val intent = Intent(this, AccountSyosai::class.java)
            startActivity(intent)
        }
    }
}

