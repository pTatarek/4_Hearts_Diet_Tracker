package com.example.a4heartsdiettracker

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class AdapterListaNazw(private val listaNazwPodAdapter: ArrayList<NazwyPrzepisowLista>) : RecyclerView.Adapter<AdapterListaNazw.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.dodaj1_lista, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = listaNazwPodAdapter[position]

        holder.potrawa.text = currentItem.nazwa_przepisu_database
        holder.przyciskPodgladu.setOnClickListener{
            val dodajAkt2 = Intent(holder.przyciskPodgladu.context, Dodaj2Activity::class.java)
            dodajAkt2.putExtra("jakiPosilek", currentItem.nazwa_przepisu_database)
            startActivity(holder.itemView.context, dodajAkt2, null)
        }
    }

    override fun getItemCount(): Int {
        return listaNazwPodAdapter.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val potrawa: TextView = itemView.findViewById(R.id.nazwa_posilku_lista_recycler)
        val przyciskPodgladu: Button = itemView.findViewById(R.id.dodaj2)
    }
}