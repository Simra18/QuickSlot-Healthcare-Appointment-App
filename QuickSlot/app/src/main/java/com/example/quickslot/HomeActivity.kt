package com.example.quickslot

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "QuickSlot"

        toolbar.navigationIcon = null

        val btnBook = findViewById<Button>(R.id.bookButton)
        val btnAppointments = findViewById<Button>(R.id.myAppointmentsButton)

        btnBook.setOnClickListener {
            startActivity(Intent(this, DoctorListActivity::class.java))
        }

        btnAppointments.setOnClickListener {
            startActivity(Intent(this, MyAppointmentsActivity::class.java))
        }
    }
}