package com.example.a4heartsdiettracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.Intent
import android.widget.Toast

class Stworz1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stworz1)

        val nazwaPosilku: EditText = findViewById(R.id.nazwa_posilku)
        val dalejButton: Button = findViewById(R.id.dalej_button)

        dalejButton.setOnClickListener{
            if(nazwaPosilku.text.isNotEmpty()){
                val nazwa: String = nazwaPosilku.text.toString()
                val stworzAkt2 = Intent(applicationContext, Stworz2Activity::class.java)
                stworzAkt2.putExtra("nazwaPosilku", nazwa)
                startActivity(stworzAkt2)
            }
            else{
                Toast.makeText(applicationContext, "Brak nazwy posiłku", Toast.LENGTH_SHORT).show()
            }
        }
    }
}