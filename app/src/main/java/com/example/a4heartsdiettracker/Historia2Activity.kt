package com.example.a4heartsdiettracker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Historia2Activity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historia2)

        val odbierzZHistoria1 = intent
        val dataHistoria1: String = odbierzZHistoria1.getStringExtra("wybranaData").toString()

        val zjedzoneTV: TextView = findViewById(R.id.posilki_historia2)
        val wartEnergH2: TextView = findViewById(R.id.wart_energ_historia2)
        val tluszczH2: TextView = findViewById(R.id.tluszcz_historia2)
        val kwasyH2: TextView = findViewById(R.id.kwasy_historia2)
        val wegleH2: TextView = findViewById(R.id.wegle_historia2)
        val cukryH2: TextView = findViewById(R.id.cukry_historia2)
        val bialkoH2: TextView = findViewById(R.id.bialko_historia2)
        val solH2: TextView = findViewById(R.id.sol_historia2)

        val db = LocalDatabase(this)
        val cursor = db.getPosilek(dataHistoria1)

        cursor!!.moveToFirst()
        zjedzoneTV.append(cursor.getString(cursor.getColumnIndexOrThrow(LocalDatabase.NAZWA_LOCAL)) + "\n")
        var wartEnergLocal: Double = cursor.getString(cursor.getColumnIndexOrThrow(LocalDatabase.WARTENERG_LOCAL)).toDouble()
        var tluszczLocal: Double = cursor.getString(cursor.getColumnIndexOrThrow(LocalDatabase.TLUSZCZ_LOCAL)).toDouble()
        var kwasyLocal: Double = cursor.getString(cursor.getColumnIndexOrThrow(LocalDatabase.KWASY_LOCAL)).toDouble()
        var wegleLocal: Double = cursor.getString(cursor.getColumnIndexOrThrow(LocalDatabase.WEGLE_LOCAL)).toDouble()
        var cukryLocal: Double = cursor.getString(cursor.getColumnIndexOrThrow(LocalDatabase.CUKRY_LOCAL)).toDouble()
        var bialkoLocal: Double = cursor.getString(cursor.getColumnIndexOrThrow(LocalDatabase.BIALKO_LOCAL)).toDouble()
        var solLocal: Double = cursor.getString(cursor.getColumnIndexOrThrow(LocalDatabase.SOL_LOCAL)).toDouble()

        while (cursor.moveToNext()){
            zjedzoneTV.append(cursor.getString(cursor.getColumnIndexOrThrow(LocalDatabase.NAZWA_LOCAL)) + "\n")
            wartEnergLocal += cursor.getString(cursor.getColumnIndexOrThrow(LocalDatabase.WARTENERG_LOCAL)).toDouble()
            tluszczLocal += cursor.getString(cursor.getColumnIndexOrThrow(LocalDatabase.TLUSZCZ_LOCAL)).toDouble()
            kwasyLocal += cursor.getString(cursor.getColumnIndexOrThrow(LocalDatabase.KWASY_LOCAL)).toDouble()
            wegleLocal += cursor.getString(cursor.getColumnIndexOrThrow(LocalDatabase.WEGLE_LOCAL)).toDouble()
            cukryLocal += cursor.getString(cursor.getColumnIndexOrThrow(LocalDatabase.CUKRY_LOCAL)).toDouble()
            bialkoLocal += cursor.getString(cursor.getColumnIndexOrThrow(LocalDatabase.BIALKO_LOCAL)).toDouble()
            solLocal += cursor.getString(cursor.getColumnIndexOrThrow(LocalDatabase.SOL_LOCAL)).toDouble()
        }

        wartEnergH2.text = "$wartEnergLocal (kcal)"
        tluszczH2.text = "$tluszczLocal (g)"
        kwasyH2.text = "$kwasyLocal (g)"
        wegleH2.text = "$wegleLocal (g)"
        cukryH2.text = "$cukryLocal (g)"
        bialkoH2.text = "$bialkoLocal (g)"
        solH2.text = "$solLocal (g)"
    }
}