package com.example.b_sket

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AccountRegistActivity : AppCompatActivity() {

    private lateinit var helper: TestOpenHelper
    private lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account_regist)

        val accountRegistCancelButton = findViewById<Button>(R.id.AccountRegistCancelButton)
        accountRegistCancelButton.setOnClickListener {
            finish()
        }
        val id = findViewById<EditText>(R.id.ac_id)
        val name = findViewById<EditText>(R.id.ac_name)
        val pass = findViewById<EditText>(R.id.pass)

        val insertButton = findViewById<Button>(R.id.createButton)
        insertButton.setOnClickListener {
            helper = TestOpenHelper(applicationContext)
            db = helper.writableDatabase
            val ac_id: String = id.text.toString()
            val pass: String = pass.text.toString()
            val ac_name: String = name.text.toString()

            insertData(db, ac_id, pass, ac_name)
        }
    }

    private fun insertData(db: SQLiteDatabase, id: String, name: String, pass: String) {
        val values = ContentValues()
        values.put("a_id", id)
        values.put("name", name)
        values.put("password", pass)
        db.insert("account", null, values)
    }
}