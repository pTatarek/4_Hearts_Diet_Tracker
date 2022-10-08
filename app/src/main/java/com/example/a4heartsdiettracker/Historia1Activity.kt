package com.example.a4heartsdiettracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.Toast

class Historia1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historia1)

        val dzienHistoria: NumberPicker = findViewById(R.id.dzienPickerHistoria)
        val miesiacHistoria: NumberPicker = findViewById(R.id.miesiacPickerHistoria)
        val rokHistoria: NumberPicker = findViewById(R.id.rokPickerHistoria)
        val wybierzBT: Button = findViewById(R.id.wybierz_historia1)

        dzienHistoria.minValue = 1
        dzienHistoria.maxValue = 31
        miesiacHistoria.minValue = 1
        miesiacHistoria.maxValue = 12
        rokHistoria.minValue = 2022
        rokHistoria.maxValue = 2030

        wybierzBT.setOnClickListener {
            val rokHist: String = rokHistoria.value.toString()

            val dzienHist: String = if(dzienHistoria.value < 10){
                "0" + dzienHistoria.value.toString()
            } else{
                dzienHistoria.value.toString()
            }

            val miesiacHist: String = if(miesiacHistoria.value < 10){
                "0" + miesiacHistoria.value.toString()
            } else{
                miesiacHistoria.value.toString()
            }

            val dataHist: String = rokHist + miesiacHist + dzienHist

            val db = LocalDatabase(this)
            val cursor = db.getPosilek(dataHist)

            if(cursor!!.moveToFirst()){
                val historiaAkt2 = Intent(applicationContext, Historia2Activity::class.java)
                historiaAkt2.putExtra("wybranaData", dataHist)
                startActivity(historiaAkt2)
            }
            else{
                Toast.makeText(applicationContext, "Brak posiłków w wybranym dniu", Toast.LENGTH_SHORT).show()
            }
        }
    }
}