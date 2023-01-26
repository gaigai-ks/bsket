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
        val pass = findViewById<EditText>(R.id.pass)
        val name = findViewById<EditText>(R.id.ac_name)


        val insertButton = findViewById<Button>(R.id.createButton)
        insertButton.setOnClickListener {
            helper = TestOpenHelper(applicationContext)
            db = helper.writableDatabase
            val ac_id: String = id.text.toString()
            val passw: String = pass.text.toString()
            val ac_name: String = name.text.toString()

            insertData(db, ac_id, passw, ac_name)

           // val createbutton = findViewById<Button>(R.id.createButton)
            //createbutton.setOnClickListener {
            //    val intent = Intent(this, Account_dekita::class.java)
              //  startActivity(intent)
        }
    }

    private fun insertData(db: SQLiteDatabase, id: String, pass: String, name: String ) {
        val values = ContentValues()
        values.put("a_id", id)
        values.put("password", pass)
        values.put("name", name)

        db.insert("account", null, values)
    }
}
//https://akira-watson.com/android/kotlin/sqlite-database.html