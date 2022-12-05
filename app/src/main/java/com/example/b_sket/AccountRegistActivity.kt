package com.example.b_sket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AccountRegistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account_regist)

        val accountRegistCancelButton = findViewById<Button>(R.id.AccountRegistCancelButton)
        accountRegistCancelButton.setOnClickListener{
            finish()
        }
    }
}