package com.example.a4heartsdiettracker

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class LocalDatabase(var context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_LOCAL + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAZWA_LOCAL + " TEXT, " + WARTENERG_LOCAL + " TEXT, " +
                TLUSZCZ_LOCAL + " TEXT, " + KWASY_LOCAL + " TEXT, " +
                WEGLE_LOCAL + " TEXT, " + CUKRY_LOCAL + " TEXT, " +
                BIALKO_LOCAL + " TEXT, " + SOL_LOCAL + " TEXT, " + DATA_LOCAL + " TEXT)" )
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addPosilek(posilek : String, wartEnerg: String, tluszcz: String, kwasy: String,
                   wegle: String, cukry: String, bialko: String, sol: String, data: String){

        val values = ContentValues()

        values.put(NAZWA_LOCAL, posilek)
        values.put(WARTENERG_LOCAL, wartEnerg)
        values.put(TLUSZCZ_LOCAL, tluszcz)
        values.put(KWASY_LOCAL, kwasy)
        values.put(WEGLE_LOCAL, wegle)
        values.put(CUKRY_LOCAL, cukry)
        values.put(BIALKO_LOCAL, bialko)
        values.put(SOL_LOCAL, sol)
        values.put(DATA_LOCAL, data)

        val db = this.writableDatabase

        db.insert(TABLE_NAME, null, values)

        db.close()
    }

    fun getPosilek(data: String): Cursor? {

        val db = this.readableDatabase

        return db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE data = " + data, null)

    }

    companion object{
        private val DATABASE_NAME = "ZJEDZONE_POSILKI"
        val TABLE_NAME = "zjedzoneposilki"

        val ID_LOCAL = "id"
        val NAZWA_LOCAL = "posilek"
        val WARTENERG_LOCAL = "wartEnerg"
        val TLUSZCZ_LOCAL = "tluszcz"
        val KWASY_LOCAL = "kwasy"
        val WEGLE_LOCAL = "wegle"
        val CUKRY_LOCAL = "cukry"
        val BIALKO_LOCAL = "bialko"
        val SOL_LOCAL = "sol"
        val DATA_LOCAL = "data"
    }
}
