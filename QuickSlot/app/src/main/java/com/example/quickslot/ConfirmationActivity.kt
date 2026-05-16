package com.example.quickslot

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        setupUI()
    }

    private fun setupUI() {

        val name = intent.getStringExtra("name") ?: "N/A"
        val speciality = intent.getStringExtra("speciality") ?: ""
        val experience = intent.getStringExtra("experience") ?: ""
        val image = intent.getIntExtra("image", 0)

        val patient = intent.getStringExtra("patient") ?: "N/A"
        val date = intent.getStringExtra("date") ?: "N/A"
        val time = intent.getStringExtra("time") ?: "N/A"
        val symptoms = intent.getStringExtra("symptoms") ?: "N/A"

        findViewById<TextView>(R.id.tvDoctor).text =
            "$name\n$speciality • $experience"

        findViewById<TextView>(R.id.tvPatient).text = "Patient: $patient"
        findViewById<TextView>(R.id.tvDate).text = "Date: $date"
        findViewById<TextView>(R.id.tvTime).text = "Time: $time"
        findViewById<TextView>(R.id.tvSymptoms).text = "Symptoms: $symptoms"

        if (image != 0) {
            findViewById<ImageView>(R.id.doctorImage).setImageResource(image)
        }

        val successIcon = findViewById<ImageView>(R.id.successIcon)
        successIcon.animate()
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(300)
            .start()

        findViewById<Button>(R.id.backButton).setOnClickListener {
            goHome()
        }
    }

    private fun goHome() {
        val intent = Intent(this, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}