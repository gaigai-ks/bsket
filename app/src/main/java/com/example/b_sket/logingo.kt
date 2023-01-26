package com.example.b_sket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class logingo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a_syosai = findViewById<Button>(R.id.syousai)
        a_syosai.setOnClickListener {
            val intent = Intent(this, ac_syosai::class.java)
            startActivity(intent)
        }

        val add = findViewById<Button>(R.id.yousei)
        val listView = findViewById<ListView>(R.id.ListView)
        setListViewAdapter(listView)



        add.setOnClickListener {
            val intent = Intent(this, youseinyuryoku::class.java)
            startActivity(intent)
        }

        listView.setOnItemClickListener { av, view, position, id ->
            val intent = Intent(this, a_text::class.java)
            val itemId = listView.adapter.getItemId(position)
            intent.putExtra("_id", itemId)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val helper = TestOpenHelper(this)
        val listView = findViewById<ListView>(R.id.ListView)
        setListViewAdapter(listView)
    }

    fun setListViewAdapter(listView: ListView) {
        val helper = TestOpenHelper(this)
        helper.readableDatabase.use { db ->
            db.query(
                "yousei", arrayOf("_id","name", "title", "message"),
                null,
                null,
                null,
                null,
                null,
                null
            )
                .use { cursor ->
                    val memoList = mutableListOf<ListItem>()
                    if (cursor.moveToFirst()) {
                        for (i in 1..cursor.count) {
                            val memoId = cursor.getInt(0)
                            val title = cursor.getString(2)
                            memoList.add(ListItem(memoId.toLong(), title))
                            cursor.moveToNext()
                        }
                    }
                    listView.adapter = CustomListAdapter(this, memoList, R.layout.list_item)
                }
        }
    }
}
