package com.example.b_sket

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.top)

        /*loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        val accountRegistButton = findViewById<Button>(R.id.AccountRegistButton)
        accountRegistButton.setOnClickListener {
            val intent = Intent(this, AccountRegistActivity::class.java)
            startActivity(intent)
        }*/
    }
}