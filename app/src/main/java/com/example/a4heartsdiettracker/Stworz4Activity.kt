package com.example.a4heartsdiettracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Stworz4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stworz4)

        val nazwaPosilku: TextView = findViewById(R.id.nazwa_posilku_stworz4)
        val dalejButton: Button = findViewById(R.id.dalej4_button)
        val instrukcja: EditText = findViewById(R.id.multi_instrukcja)

        val odbierzNazweStworz4 = intent
        val nazwaStworz4: String = odbierzNazweStworz4.getStringExtra("nazwaPosilku").toString()

        val laczenie4 = "$nazwaStworz4 - instrukcja przygotowania"
        nazwaPosilku.text = laczenie4

        dalejButton.setOnClickListener{
            if(instrukcja.text.isEmpty()){
                Toast.makeText(applicationContext, "Brak instrukcji przygotowania posiłku", Toast.LENGTH_SHORT).show()
            }
            else{
                val instrukcjatxt: String = instrukcja.text.toString()
                val stworzAkt5 = Intent(applicationContext, Stworz5Activity::class.java)
                stworzAkt5.putExtra("nazwaPosilku", nazwaStworz4)
                stworzAkt5.putExtra("instrukcja", instrukcjatxt)
                stworzAkt5.putExtra("wartEnerg", odbierzNazweStworz4.getStringExtra("wartEnerg").toString())
                stworzAkt5.putExtra("tluszcz", odbierzNazweStworz4.getStringExtra("tluszcz").toString())
                stworzAkt5.putExtra("kwasy", odbierzNazweStworz4.getStringExtra("kwasy").toString())
                stworzAkt5.putExtra("weglow", odbierzNazweStworz4.getStringExtra("weglow").toString())
                stworzAkt5.putExtra("cukry", odbierzNazweStworz4.getStringExtra("cukry").toString())
                stworzAkt5.putExtra("bialko", odbierzNazweStworz4.getStringExtra("bialko").toString())
                stworzAkt5.putExtra("sol", odbierzNazweStworz4.getStringExtra("sol").toString())
                stworzAkt5.putExtra("porcje", odbierzNazweStworz4.getStringExtra("porcje").toString())
                stworzAkt5.putExtra("skladniki", odbierzNazweStworz4.getStringExtra("skladniki").toString())
                startActivity(stworzAkt5)
            }
        }
    }
}