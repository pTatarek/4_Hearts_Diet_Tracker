package com.example.a4heartsdiettracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class Dodaj1Activity : AppCompatActivity() {
    private lateinit var myRef: DatabaseReference
    private lateinit var nazwyRecyclerView: RecyclerView
    private lateinit var nazwyArrayList: ArrayList<NazwyPrzepisowLista>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dodaj1)

        nazwyRecyclerView = findViewById(R.id.Dodaj1Recycler)

        nazwyRecyclerView.layoutManager = LinearLayoutManager(this)
        nazwyRecyclerView.adapter

        nazwyArrayList = arrayListOf()
        getUserData()

    }

    private fun getUserData() {
        myRef = FirebaseDatabase.getInstance("https://hearts-diet-tracker-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Przepisy")
        myRef.addValueEventListener(object: ValueEventListener{

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                if(dataSnapshot.exists()){
                    for(n in dataSnapshot.children){
                        val nazwa = n.getValue(NazwyPrzepisowLista::class.java)
                        nazwyArrayList.add(nazwa!!)
                    }
                    nazwyRecyclerView.adapter = AdapterListaNazw(nazwyArrayList)
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}