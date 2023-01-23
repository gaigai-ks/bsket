package com.example.b_sket

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var helper: TestOpenHelper
    private lateinit var db: SQLiteDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val loginCancelButton = findViewById<Button>(R.id.retrun_button)
        loginCancelButton.setOnClickListener {
            finish()
        }


        val loginButton = findViewById<Button>(R.id.login_button)
        loginButton.setOnClickListener {

            helper = TestOpenHelper(applicationContext)
            db = helper.readableDatabase

            val iD = findViewById<EditText>(R.id.accountId)
            val pASS = findViewById<EditText>(R.id.passWord)



            val id = iD.getText().toString()
            val pass = pASS.getText().toString()

            var a_id = ""
            var password = ""


            //val sql = "SELECT a_id,password FROM account WHERE a_id = ${iD} "

            val cursor = db.query(
                "account", arrayOf("a_id", "password"),
                null,
                null,
                null,
                null,
                null
            )
            cursor.moveToFirst()

            for (i in 0 until cursor.count) {
                a_id = cursor.getString(0)
                password = cursor.getString(1)
                Log.w("a_id",a_id)
                Log.w("password",password)
                Log.w("id",id)
                Log.w("pass",pass)




                if (id == a_id && pass == password ) {
                    val intent = Intent(this, logingo::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(applicationContext, "ログイン失敗", Toast.LENGTH_SHORT).show()
                    cursor.moveToNext()
                }

            }

            // 忘れずに！
            cursor.close()


//            while (cursor.moveToNext()) {
//                // カラムのインデックス値を取得。
//                val indxid = cursor.getColumnIndex("a_id")
//                val indxpass = cursor.getColumnIndex("password")
//
//
//                // カラムのインデックス値を元に実際のデータを取得。
//                a_id = cursor.getString(indxid)
//                password = cursor.getString(indxpass)
//
//
//
//            }
//            if (id.equals(a_id)&& pass.equals(password) ) {
//            val intent = Intent(this, logingo::class.java)
//            startActivity(intent)
//        } else {
//            Toast.makeText(applicationContext, "ログイン失敗", Toast.LENGTH_SHORT).show()
//        }
        }

    }
}



