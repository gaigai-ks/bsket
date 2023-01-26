package com.example.b_sket

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class TestOpenHelper internal constructor(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {

        // テーブル作成
        // SQLiteファイルがなければSQLiteファイルが作成される
        db.execSQL(
            SQL_CREATE_ENTRIES_1
        )
        db.execSQL(
            SQL_CREATE_ENTRIES_2
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // アップデートの判別
        db.execSQL(
            SQL_DELETE_ENTRIES_1
        )
        db.execSQL(
            SQL_DELETE_ENTRIES_2
        )
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    companion object {
        // データーベースのバージョン
        private const val DATABASE_VERSION = 1

        // データーベース名
        private const val DATABASE_NAME = "Bsket.db"
        private const val TABLE_NAME1 = "account"
        private const val _ID = "_id"
        private const val ac_id = "a_id"
        private const val ac_name = "name"
        private const val pass = "password"
        private const val SQL_CREATE_ENTRIES_1 = "CREATE TABLE " + TABLE_NAME1 + " (" +
                _ID + " INTEGER PRIMARY KEY," +
                ac_id + " TEXT ," +
                pass + " TEXT," +
                ac_name + " TEXT)"
        private const val SQL_DELETE_ENTRIES_1 = "DROP TABLE IF EXISTS " + TABLE_NAME1

        private const val TABLE_NAME2 = "yousei"
        private const val _ID1 = "_id"
        private const val name = "name"
        private const val title = "title"
        private const val message = "message"
        private const val latitude = "latitude"
        private const val longitude = "longitude"
        private const val SQL_CREATE_ENTRIES_2 = "CREATE TABLE " + TABLE_NAME2 + " (" +
                _ID1 + " INTEGER PRIMARY KEY," +
                name + " TEXT ," +
                title + " TEXT," +
                message + " TEXT," +
                latitude + " REAL,"+
                longitude + " REAL)"
        private const val SQL_DELETE_ENTRIES_2 = "DROP TABLE IF EXISTS " + TABLE_NAME2
    }
}