package com.example.a4heartsdiettracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Stworz2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stworz2)

        val nazwaPosilku: TextView = findViewById(R.id.nazwa_posilku_stworz2)
        val dalejButton: Button = findViewById(R.id.dalej2_button)
        val wartEnerg: EditText = findViewById(R.id.we)
        val tluszcz: EditText = findViewById(R.id.tl)
        val kwasy: EditText = findViewById(R.id.ktn)
        val weglow: EditText = findViewById(R.id.wegl)
        val cukry: EditText = findViewById(R.id.cu)
        val bialko: EditText = findViewById(R.id.bia)
        val sol: EditText = findViewById(R.id.so)

        var wartEnergtxt: String
        var tluszcztxt: String
        var kwasytxt: String
        var weglowtxt: String
        var cukrytxt: String
        var bialkotxt: String
        var soltxt: String

        val odbierzNazweStworz2 = intent
        val nazwaStworz2: String = odbierzNazweStworz2.getStringExtra("nazwaPosilku").toString()

        val laczenie = "$nazwaStworz2 - wartość odżywcza dla całego posiłku"
        nazwaPosilku.text = laczenie

        dalejButton.setOnClickListener{
            wartEnergtxt = if(wartEnerg.text.isEmpty()){
                "0"
            } else{
                wartEnerg.text.toString()
            }
            tluszcztxt = if(tluszcz.text.isEmpty()){
                "0"
            } else{
                tluszcz.text.toString()
            }
            kwasytxt = if(kwasy.text.isEmpty()){
                "0"
            } else{
                kwasy.text.toString()
            }
            weglowtxt = if(weglow.text.isEmpty()){
                "0"
            } else{
                weglow.text.toString()
            }
            cukrytxt = if(cukry.text.isEmpty()){
                "0"
            } else{
                cukry.text.toString()
            }
            bialkotxt = if(bialko.text.isEmpty()){
                "0"
            } else{
                bialko.text.toString()
            }
            soltxt = if(sol.text.isEmpty()){
                "0"
            } else{
                sol.text.toString()
            }

            val stworzAkt3 = Intent(applicationContext, Stworz3Activity::class.java)
            stworzAkt3.putExtra("nazwaPosilku", nazwaStworz2)
            stworzAkt3.putExtra("wartEnerg", wartEnergtxt)
            stworzAkt3.putExtra("tluszcz", tluszcztxt)
            stworzAkt3.putExtra("kwasy", kwasytxt)
            stworzAkt3.putExtra("weglow", weglowtxt)
            stworzAkt3.putExtra("cukry", cukrytxt)
            stworzAkt3.putExtra("bialko", bialkotxt)
            stworzAkt3.putExtra("sol", soltxt)
            startActivity(stworzAkt3)
        }
    }
}