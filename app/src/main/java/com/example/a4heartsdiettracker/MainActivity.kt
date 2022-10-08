package com.example.a4heartsdiettracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dodajButton: Button = findViewById(R.id.dodaj_button)
        val stworzButton: Button = findViewById(R.id.stworz_button)
        val historiaButton: Button = findViewById(R.id.historia_button)

        stworzButton.setOnClickListener {
            val stworzAkt = Intent(applicationContext, Stworz1Activity::class.java)
            startActivity(stworzAkt)
        }
        dodajButton.setOnClickListener {
            val dodajAkt = Intent(applicationContext, Dodaj1Activity::class.java)
            startActivity(dodajAkt)
        }
        historiaButton.setOnClickListener {
            val historiaAkt = Intent(applicationContext, Historia1Activity::class.java)
            startActivity(historiaAkt)
        }
    }
}