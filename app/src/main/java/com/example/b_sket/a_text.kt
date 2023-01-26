package com.example.b_sket

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class a_text: AppCompatActivity() {

    companion object{
        private const val TABLE_NAME="yousei"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)

        val nabiButton = findViewById<Button>(R.id.mapButton)
        nabiButton.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        val helper = TestOpenHelper(this)
        val textTitle = findViewById<TextView>(R.id.editTitle)
        val textContent  = findViewById<TextView>(R.id.editContents)
        val memoId: Long = intent.getLongExtra("_id",0)
        if (memoId != 0L) {
            helper.readableDatabase.use {
                    db -> db.query(TABLE_NAME, arrayOf("_id", "name", "title","message"), "_id = ?", arrayOf(memoId.toString()), null, null, null, "1")
                .use { cursor ->
                    if (cursor.moveToFirst()) {
                        textTitle.setText(cursor.getString(2))
                        textContent.setText(cursor.getString(3))
                        Log.w("title",textTitle.toString())
                        Log.w("naiyo",textContent.toString())
                    }
                }
            }
        }

//        findViewById<Button>(R.id.delete_button).setOnClickListener {
//            helper.writableDatabase.use {
//                    db ->
//                db.delete(TABLE_NAME, "id = ?", arrayOf(memoId.toString()))
//                Toast.makeText(this, "削除しました", Toast.LENGTH_SHORT).show()
//            }
//            finish()
//        }

        findViewById<Button>(R.id.btn_cancel).setOnClickListener {
            finish()
        }
    }
}
