package com.example.b_sket

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity()  {
    private lateinit var helper: TestOpenHelper
    private lateinit var db: SQLiteDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val loginCancelButton = findViewById<Button>(R.id.retrun_button)
        loginCancelButton.setOnClickListener {
            finish()
        }
        val iD = findViewById<EditText>(R.id.accountId)
        val pASS = findViewById<EditText>(R.id.passWord)

        val id=iD.toString()
        val pass=pASS.toString()

        var indxId=""
        var indxPass=""

        val loginButton=findViewById<Button>(R.id.login_button)
        loginButton.setOnClickListener{
           val sql="SELECT * FROM account WHERE id=${id}"

            val cursor = db.rawQuery(sql, null)

            while(cursor.moveToNext()) {
                // カラムのインデックス値を取得。
                val indxid = cursor.getColumnIndex("a_id")
                val indxpass=cursor.getColumnIndex("password")

                // カラムのインデックス値を元に実際のデータを取得。
                indxId = cursor.getString(indxid)
                indxPass=cursor.getString(indxpass)
            }
            val sw= if(id==indxId && pass==indxPass){
                "true"
            }else{
                "false"
            }
            //判定部---swの中身によって遷移先を変える
            if (sw=="true"){
                val intent = Intent(this,logingo ::class.java)
                startActivity(intent)
            }else{

            }

        }



    }
}