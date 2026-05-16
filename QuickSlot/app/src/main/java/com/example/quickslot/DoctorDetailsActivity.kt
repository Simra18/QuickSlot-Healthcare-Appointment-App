package com.example.quickslot

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class DoctorDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_details)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.title = "Doctor Details"
        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val name = intent.getStringExtra("name") ?: "Doctor Name"
        val speciality = intent.getStringExtra("speciality") ?: "Speciality not available"
        val experience = intent.getStringExtra("experience") ?: "Experience not available"
        val image = intent.getIntExtra("image", 0) // no placeholder dependency

        val nameText = findViewById<TextView>(R.id.doctorName)
        val detailsText = findViewById<TextView>(R.id.doctorDetails)
        val imageView = findViewById<ImageView>(R.id.doctorImage)
        val bookButton = findViewById<Button>(R.id.bookButton)

        nameText.text = name
        detailsText.text = "$speciality\n$experience"

        if (image != 0) {
            imageView.setImageResource(image)
        }

        bookButton.setOnClickListener {
            val bookingIntent = Intent(this, BookingActivity::class.java).apply {
                putExtra("name", name)
                putExtra("speciality", speciality)
                putExtra("experience", experience)
                putExtra("image", image)
            }

            startActivity(bookingIntent)
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
        }
    }
}