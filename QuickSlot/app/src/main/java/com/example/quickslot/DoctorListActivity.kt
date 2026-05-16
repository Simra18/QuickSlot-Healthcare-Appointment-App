package com.example.quickslot

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class DoctorListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_list)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Select Doctor"

        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        val recycler = findViewById<RecyclerView>(R.id.doctorRecycler)
        recycler.layoutManager = LinearLayoutManager(this)

        val doctorList = listOf(
            Doctor("Dr Sharma", "Cardiologist", "10 years", R.drawable.doctor1),
            Doctor("Dr Khan", "Dermatologist", "8 years", R.drawable.doctor2),
            Doctor("Dr Mehta", "Dentist", "6 years", R.drawable.doctor3),
            Doctor("Dr Rao", "Neurologist", "12 years", R.drawable.doctor4),
            Doctor("Dr Patel", "Orthopedic", "9 years", R.drawable.doctor5),
            Doctor("Dr Iyer", "General Physician", "7 years", R.drawable.doctor6)
        )

        val adapter = DoctorAdapter(doctorList) { doctor ->
            val intent = Intent(this, DoctorDetailsActivity::class.java)

            intent.putExtra("name", doctor.name)
            intent.putExtra("speciality", doctor.speciality)
            intent.putExtra("experience", doctor.experience)
            intent.putExtra("image", doctor.image)

            startActivity(intent)
        }

        recycler.adapter = adapter
    }
}