package com.example.b_sket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ac_syosai : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.accountsyousai2)

        val logout = findViewById<Button>(R.id.logout)
        logout.setOnClickListener {
            val intent = Intent(this, Logout::class.java)
            startActivity(intent)
        }


        val back = findViewById<Button>(R.id.back)
        back.setOnClickListener {
            finish()
        }
    }
}