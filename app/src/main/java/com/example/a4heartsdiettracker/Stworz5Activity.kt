package com.example.a4heartsdiettracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Stworz5Activity : AppCompatActivity() {
    private lateinit var myRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stworz5)

        val nazwaPosilku: TextView = findViewById(R.id.nazwa_posilku_stworz5)
        val stworzButton: Button = findViewById(R.id.stworz_final_button)
        val porcjeTV: TextView = findViewById(R.id.porcje5)
        val skladnikiTV: TextView = findViewById(R.id.skladniki5)
        val instrukcjaTV: TextView = findViewById(R.id.instrukcja5)
        val weTV: TextView = findViewById(R.id.wart_energ5)
        val tlTV: TextView = findViewById(R.id.tluszcz5)
        val kwasyTV: TextView = findViewById(R.id.kwasy5)
        val wegleTV: TextView = findViewById(R.id.wegle5)
        val cukryTV: TextView = findViewById(R.id.cukry5)
        val bialkoTV: TextView = findViewById(R.id.bialko5)
        val solTV: TextView = findViewById(R.id.sol5)

        val odbierzNazweStworz5 = intent
        val nazwaStworz5: String = odbierzNazweStworz5.getStringExtra("nazwaPosilku").toString()
        val iloscPorcji5: String = odbierzNazweStworz5.getStringExtra("porcje").toString()
        val skladniki5: String = odbierzNazweStworz5.getStringExtra("skladniki").toString()
        val instrukcja5: String = odbierzNazweStworz5.getStringExtra("instrukcja").toString()
        val we5: String = odbierzNazweStworz5.getStringExtra("wartEnerg").toString()
        val tl5: String = odbierzNazweStworz5.getStringExtra("tluszcz").toString()
        val kwasy5: String = odbierzNazweStworz5.getStringExtra("kwasy").toString()
        val wegle5: String = odbierzNazweStworz5.getStringExtra("weglow").toString()
        val cukry5: String = odbierzNazweStworz5.getStringExtra("cukry").toString()
        val bialko5: String = odbierzNazweStworz5.getStringExtra("bialko").toString()
        val sol5: String = odbierzNazweStworz5.getStringExtra("sol").toString()

        nazwaPosilku.text = nazwaStworz5
        skladnikiTV.text = skladniki5
        instrukcjaTV.text = instrukcja5
        porcjeTV.text = iloscPorcji5

        val we5Laczenie = "$we5 (kcal)"
        weTV.text = we5Laczenie

        val tl5Laczenie = "$tl5 (g)"
        tlTV.text = tl5Laczenie

        val kwasy5Laczenie = "$kwasy5 (g)"
        kwasyTV.text = kwasy5Laczenie

        val wegle5Laczenie = "$wegle5 (g)"
        wegleTV.text = wegle5Laczenie

        val cukry5Laczenie = "$cukry5 (g)"
        cukryTV.text = cukry5Laczenie

        val bialko5Laczenie = "$bialko5 (g)"
        bialkoTV.text = bialko5Laczenie

        val sol5Laczenie = "$sol5 (g)"
        solTV.text = sol5Laczenie

        val firebase: FirebaseDatabase = FirebaseDatabase.getInstance("https://hearts-diet-tracker-default-rtdb.europe-west1.firebasedatabase.app/")
        myRef = firebase.getReference("Przepisy").child(nazwaStworz5)

        stworzButton.setOnClickListener{
            val stworzWycofanie = Intent(applicationContext, MainActivity::class.java)
            val firebaseInput = Przepisy(nazwa_przepisu_database = nazwaStworz5, porcje_database = iloscPorcji5, skladniki_database = skladniki5,
            instrukcja_database = instrukcja5, wartEnerg_database = we5, tluszcz_database = tl5, kwasy_database = kwasy5,
            wegle_database = wegle5, cukry_database = cukry5, bialko_database = bialko5, sol_database = sol5)
            myRef.setValue(firebaseInput)
            Toast.makeText(applicationContext, "Przepis został pomyślnie dodany", Toast.LENGTH_SHORT).show()
            startActivity(stworzWycofanie)
        }
    }
}