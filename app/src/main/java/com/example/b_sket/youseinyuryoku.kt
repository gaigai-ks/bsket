package com.example.b_sket

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class youseinyuryoku : AppCompatActivity() {


    private lateinit var helper: TestOpenHelper
    private lateinit var db: SQLiteDatabase
//    lateinit var fusedLocationProviderClient: FusedLocationProviderClient



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kyujoyouseinyuryoku)


        val back = findViewById<Button>(R.id.back1)
        back.setOnClickListener {
            finish()
        }



        val name = "test"
        val title = findViewById<EditText>(R.id.titletext)
        val message = findViewById<EditText>(R.id.naiyou)
//        fusedLocationProviderClient =
//            LocationServices.getFusedLocationProviderClient(this)


        val insertButton = findViewById<Button>(R.id.kakutei)
        insertButton.setOnClickListener {
            helper = TestOpenHelper(applicationContext)
            db = helper.writableDatabase
            val naiyo: String = message.text.toString()
            val tile: String = title.text.toString()
            val namae: String = name
            var lat = 0.0
            var lon = 0.0


//            val fusedLocationClient: FusedLocationProviderClient =
//                LocationServices.getFusedLocationProviderClient(this)
//            if (ActivityCompat.checkSelfPermission(
//                    this,
//                    Manifest.permission.ACCESS_FINE_LOCATION
//                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                    this,
//                    Manifest.permission.ACCESS_COARSE_LOCATION
//                ) != PackageManager.PERMISSION_GRANTED
//            )
//            fusedLocationClient.getLastLocation()
//                .addOnSuccessListener(this) { location ->
//                    if (location != null) {
//
//                        // Logic to handle location object
//                        // 緯度の表示
//                        val Latlng = LatLng(location.getLatitude(), location.getLongitude()) //緯度・経度
//                        lat = Latlng.latitude
//
//                        // 経度の表示
//                        lon = Latlng.longitude
//                    }
//                }



            insertData(db, namae, tile, naiyo, lat, lon)




            Log.w("naiyo", naiyo)
            Log.w("title", tile)
            Log.w("name", namae)
            Log.w("lat", lat.toString())
            Log.w("lon", lon.toString())


            // val createbutton = findViewById<Button>(R.id.createButton)
            //createbutton.setOnClickListener {
            //    val intent = Intent(this, Account_dekita::class.java)
            //  startActivity(intent)

            val intent = Intent(this, logingo::class.java)
            startActivity(intent)
        }
    }

    private fun insertData(
        db: SQLiteDatabase,
        name: String,
        titl: String,
        messe: String,
        lat: Double,
        lon: Double
    ) {
        val values = ContentValues()
        values.put("name", name)
        values.put("title", titl)
        values.put("message", messe)
        values.put("latitude", lat)
        values.put("longitude", lon)


        db.insert("yousei", null, values)
    }
}