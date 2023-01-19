package com.example.b_sket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Logout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.logout)

        val yes = findViewById<Button>(R.id.yes)
        yes.setOnClickListener {
            val intent = Intent(this, Logout_ok::class.java)
            startActivity(intent)
        }

        val no = findViewById<Button>(R.id.no)
        no.setOnClickListener {
            finish()
        }
    }
}