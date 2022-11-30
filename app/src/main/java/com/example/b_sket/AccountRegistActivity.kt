package com.example.b_sket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AccountRegistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.accountregist)

        val accountRegistCancelButton = findViewById<Button>(R.id.AccountRegistCancelButton)
        accountRegistCancelButton.setOnClickListener{
            finish()
        }
    }
}