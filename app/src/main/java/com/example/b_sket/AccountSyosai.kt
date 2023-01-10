package com.example.b_sket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AccountSyosai : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.accountsyousai2)

        val back = findViewById<Button>(R.id.back)
        back.setOnClickListener {
            finish()
        }
        val logout = findViewById<Button>(R.id.logout)
        logout.setOnClickListener {
            val intent = Intent(this, Logout::class.java)
            startActivity(intent)
        }
    }
}