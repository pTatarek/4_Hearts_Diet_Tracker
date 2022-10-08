package com.example.a4heartsdiettracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Dodaj3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dodaj3)

        val napisDodaj3: TextView = findViewById(R.id.porcje_dodaj3)
        val iloscPorcji3: EditText = findViewById(R.id.ilosc_porcji_dodaj3)
        val dodaj3Button: Button = findViewById(R.id.dodaj_posilek_dodaj3)

        val dzienNP: NumberPicker = findViewById(R.id.dzienPicker)
        val miesiacNP: NumberPicker = findViewById(R.id.miesiacPicker)
        val rokNP: NumberPicker = findViewById(R.id.rokPicker)

        dzienNP.minValue = 1
        dzienNP.maxValue = 31
        miesiacNP.minValue = 1
        miesiacNP.maxValue = 12
        rokNP.minValue = 2022
        rokNP.maxValue = 2030

        val odbierzZDodaj2 = intent
        val nazwaPosilkuDodaj3: String = odbierzZDodaj2.getStringExtra("wybrany_posilek").toString()
        val porcjeDodaj3: String = odbierzZDodaj2.getStringExtra("ilosc_porcji").toString()
        val wartEnergCalosc: String = odbierzZDodaj2.getStringExtra("wartEnerg_wybrany").toString()
        val tluszczCalosc: String = odbierzZDodaj2.getStringExtra("tluszcz_wybrany").toString()
        val kwasyCalosc: String = odbierzZDodaj2.getStringExtra("kwasy_wybrany").toString()
        val wegleCalosc: String = odbierzZDodaj2.getStringExtra("wegle_wybrany").toString()
        val cukryCalosc: String = odbierzZDodaj2.getStringExtra("cukry_wybrany").toString()
        val bialkoCalosc: String = odbierzZDodaj2.getStringExtra("bialko_wybrany").toString()
        val solCalosc: String = odbierzZDodaj2.getStringExtra("sol_wybrany").toString()

        val tekstPorcje = "Wybrany posiłek zawiera następującą ilość porcji: $porcjeDodaj3"

        napisDodaj3.text = tekstPorcje

        dodaj3Button.setOnClickListener{

            if(iloscPorcji3.text.isEmpty()){
                Toast.makeText(applicationContext, "Brak ilości porcji", Toast.LENGTH_SHORT).show()
            }
            else{
                val porcje: String = iloscPorcji3.text.toString()
                val porcjeDouble: Double = porcje.toDouble()

                val wartEnergPorcja: Double = wartEnergCalosc.toDouble() / porcjeDodaj3.toDouble() * porcjeDouble
                val tluszczPorcja: Double = tluszczCalosc.toDouble() / porcjeDodaj3.toDouble() * porcjeDouble
                val kwasyPorcja: Double = kwasyCalosc.toDouble() / porcjeDodaj3.toDouble() * porcjeDouble
                val weglePorcja: Double = wegleCalosc.toDouble() / porcjeDodaj3.toDouble() * porcjeDouble
                val cukryPorcja: Double = cukryCalosc.toDouble() / porcjeDodaj3.toDouble() * porcjeDouble
                val bialkoPorcja: Double = bialkoCalosc.toDouble() / porcjeDodaj3.toDouble() * porcjeDouble
                val solPorcja: Double = solCalosc.toDouble() / porcjeDodaj3.toDouble() * porcjeDouble

                val rok: String = rokNP.value.toString()

                val dzien: String = if(dzienNP.value < 10){
                    "0" + dzienNP.value.toString()
                } else{
                    dzienNP.value.toString()
                }

                val miesiac: String = if(miesiacNP.value < 10){
                    "0" + miesiacNP.value.toString()
                } else{
                    miesiacNP.value.toString()
                }

                val data: String = rok + miesiac + dzien

                val db = LocalDatabase(this)
                db.addPosilek(nazwaPosilkuDodaj3, wartEnergPorcja.toString(), tluszczPorcja.toString(),
                    kwasyPorcja.toString(), weglePorcja.toString(), cukryPorcja.toString(),
                    bialkoPorcja.toString(), solPorcja.toString(), data)

                val dodajWycofanie = Intent(applicationContext, MainActivity::class.java)
                Toast.makeText(applicationContext, "Posiłek został pomyślnie dodany", Toast.LENGTH_SHORT).show()
                startActivity(dodajWycofanie)
            }
        }
    }
}