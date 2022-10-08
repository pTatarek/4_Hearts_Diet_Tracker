package com.example.a4heartsdiettracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.a4heartsdiettracker.databinding.ActivityDodaj2Binding
import com.google.firebase.database.*

class Dodaj2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityDodaj2Binding
    private lateinit var myRefDodaj2: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDodaj2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val dodaj2Button: Button = findViewById(R.id.dodaj_posilek_dodaj2)

        readData()

        dodaj2Button.setOnClickListener{
            val dodajAkt3 = Intent(applicationContext, Dodaj3Activity::class.java)
            dodajAkt3.putExtra("ilosc_porcji", binding.porcjeDodaj2.text)
            dodajAkt3.putExtra("wybrany_posilek", binding.nazwaPosilkuDodaj2.text)
            dodajAkt3.putExtra("wartEnerg_wybrany", binding.wartEnergInv.text)
            dodajAkt3.putExtra("tluszcz_wybrany", binding.tluszczInv.text)
            dodajAkt3.putExtra("kwasy_wybrany", binding.kwasyInv.text)
            dodajAkt3.putExtra("wegle_wybrany", binding.wegleInv.text)
            dodajAkt3.putExtra("cukry_wybrany", binding.cukryInv.text)
            dodajAkt3.putExtra("bialko_wybrany", binding.bialkoInv.text)
            dodajAkt3.putExtra("sol_wybrany", binding.solInv.text)
            startActivity(dodajAkt3)
        }
    }

    private fun readData() {
        val odbierz = intent
        myRefDodaj2 = FirebaseDatabase.getInstance("https://hearts-diet-tracker-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Przepisy").child(odbierz.getStringExtra("jakiPosilek").toString())
        myRefDodaj2.get().addOnSuccessListener {
            if (it.exists()){
                val przepisFromDatabase = it.child("nazwa_przepisu_database").value
                val porcjeFromDatabase = it.child("porcje_database").value
                val skladnikiFromDatabase = it.child("skladniki_database").value
                val instrukcjaFromDatabase = it.child("instrukcja_database").value
                val wartEnergFromDatabase = it.child("wartEnerg_database").value
                val wartEnergLaczenie = "$wartEnergFromDatabase (kcal)"
                val tluszczFromDatabase = it.child("tluszcz_database").value
                val tluszczLaczenie = "$tluszczFromDatabase (g)"
                val kwasyFromDatabase = it.child("kwasy_database").value
                val kwasyLaczenie = "$kwasyFromDatabase (g)"
                val wegleFromDatabase = it.child("wegle_database").value
                val wegleLaczenie = "$wegleFromDatabase (g)"
                val cukryFromDatabase = it.child("cukry_database").value
                val cukryLaczenie = "$cukryFromDatabase (g)"
                val bialkoFromDatabase = it.child("bialko_database").value
                val bialkoLaczenie = "$bialkoFromDatabase (g)"
                val solFromDatabase = it.child("sol_database").value
                val solLaczenie = "$solFromDatabase (g)"
                binding.nazwaPosilkuDodaj2.text = przepisFromDatabase.toString()
                binding.porcjeDodaj2.text = porcjeFromDatabase.toString()
                binding.skladnikiDodaj2.text = skladnikiFromDatabase.toString()
                binding.instrukcjaDodaj2.text = instrukcjaFromDatabase.toString()
                binding.wartEnergDodaj2.text = wartEnergLaczenie
                binding.tluszczDodaj2.text = tluszczLaczenie
                binding.kwasyDodaj2.text = kwasyLaczenie
                binding.wegleDodaj2.text = wegleLaczenie
                binding.cukryDodaj2.text = cukryLaczenie
                binding.bialkoDodaj2.text = bialkoLaczenie
                binding.solDodaj2.text = solLaczenie
                binding.wartEnergInv.text = wartEnergFromDatabase.toString()
                binding.tluszczInv.text = tluszczFromDatabase.toString()
                binding.kwasyInv.text = kwasyFromDatabase.toString()
                binding.wegleInv.text = wegleFromDatabase.toString()
                binding.cukryInv.text = cukryFromDatabase.toString()
                binding.bialkoInv.text = bialkoFromDatabase.toString()
                binding.solInv.text = solFromDatabase.toString()
            }
        }
    }
}