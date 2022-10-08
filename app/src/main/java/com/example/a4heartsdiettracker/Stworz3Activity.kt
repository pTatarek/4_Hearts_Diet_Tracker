package com.example.a4heartsdiettracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Stworz3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stworz3)

        val nazwaPosilku: TextView = findViewById(R.id.nazwa_posilku_stworz3)
        val dalejButton: Button = findViewById(R.id.dalej3_button)
        val porcje: EditText = findViewById(R.id.porcje)
        val skladniki: EditText = findViewById(R.id.multi_skladniki)

        val odbierzNazweStworz3 = intent
        val nazwaStworz3: String = odbierzNazweStworz3.getStringExtra("nazwaPosilku").toString()

        val laczenie3 = "$nazwaStworz3 - ilość porcji i składniki"
        nazwaPosilku.text = laczenie3

        dalejButton.setOnClickListener{
            when {
                porcje.text.isEmpty() -> {
                    Toast.makeText(applicationContext, "Brak ilości porcji", Toast.LENGTH_SHORT).show()
                }
                skladniki.text.isEmpty() -> {
                    Toast.makeText(applicationContext, "Brak składników posiłku", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val porcjetxt: String = porcje.text.toString()
                    val skladnikitxt: String = skladniki.text.toString()
                    val stworzAkt4 = Intent(applicationContext, Stworz4Activity::class.java)
                    stworzAkt4.putExtra("nazwaPosilku", nazwaStworz3)
                    stworzAkt4.putExtra("porcje", porcjetxt)
                    stworzAkt4.putExtra("skladniki", skladnikitxt)
                    stworzAkt4.putExtra("wartEnerg", odbierzNazweStworz3.getStringExtra("wartEnerg").toString())
                    stworzAkt4.putExtra("tluszcz", odbierzNazweStworz3.getStringExtra("tluszcz").toString())
                    stworzAkt4.putExtra("kwasy", odbierzNazweStworz3.getStringExtra("kwasy").toString())
                    stworzAkt4.putExtra("weglow", odbierzNazweStworz3.getStringExtra("weglow").toString())
                    stworzAkt4.putExtra("cukry", odbierzNazweStworz3.getStringExtra("cukry").toString())
                    stworzAkt4.putExtra("bialko", odbierzNazweStworz3.getStringExtra("bialko").toString())
                    stworzAkt4.putExtra("sol", odbierzNazweStworz3.getStringExtra("sol").toString())
                    startActivity(stworzAkt4)
                }
            }
        }
    }
}