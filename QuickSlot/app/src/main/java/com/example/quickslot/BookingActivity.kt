package com.example.quickslot

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import java.util.*

class BookingActivity : AppCompatActivity() {

    private lateinit var patientName: EditText
    private lateinit var dateField: EditText
    private lateinit var timeField: EditText
    private lateinit var symptomField: EditText
    private lateinit var confirmButton: Button

    private var doctorName: String = ""
    private var speciality: String = ""
    private var experience: String = ""
    private var image: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        setupToolbar()
        getIntentData()
        initViews()
        setupDoctorUI()
        setupDateTimePickers()
        setupConfirmButton()
    }

    private fun setupToolbar() {
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.title = "Book Appointment"
        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun getIntentData() {
        doctorName = intent.getStringExtra("name") ?: "Doctor"
        speciality = intent.getStringExtra("speciality") ?: ""
        experience = intent.getStringExtra("experience") ?: ""
        image = intent.getIntExtra("image", 0)
    }

    private fun initViews() {
        patientName = findViewById(R.id.patientName)
        dateField = findViewById(R.id.dateField)
        timeField = findViewById(R.id.timeField)
        symptomField = findViewById(R.id.symptomField)
        confirmButton = findViewById(R.id.confirmButton)
    }

    private fun setupDoctorUI() {
        findViewById<TextView>(R.id.doctorName).text = doctorName
        findViewById<TextView>(R.id.doctorDetails).text = "$speciality • $experience"

        if (image != 0) {
            findViewById<ImageView>(R.id.doctorImage).setImageResource(image)
        }
    }

    private fun setupDateTimePickers() {
        dateField.isFocusable = false
        timeField.isFocusable = false

        dateField.setOnClickListener {
            val cal = Calendar.getInstance()
            DatePickerDialog(
                this,
                { _, y, m, d -> dateField.setText("$d/${m + 1}/$y") },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        timeField.setOnClickListener {
            val cal = Calendar.getInstance()
            TimePickerDialog(
                this,
                { _, h, m -> timeField.setText(String.format("%02d:%02d", h, m)) },
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }
    }

    private fun setupConfirmButton() {
        confirmButton.setOnClickListener {

            if (!validateInputs()) return@setOnClickListener

            confirmButton.isEnabled = false

            val patient = patientName.text.toString()
            val date = dateField.text.toString()
            val time = timeField.text.toString()
            val symptoms = symptomField.text.toString()

            val appointmentId = generateAppointmentId()

            saveAppointment(
                appointmentId,
                patient,
                doctorName,
                date,
                time,
                symptoms
            )

            Toast.makeText(this, "Appointment Booked", Toast.LENGTH_SHORT).show()

            navigateToConfirmation(
                appointmentId,
                patient,
                date,
                time,
                symptoms
            )
        }
    }

    private fun validateInputs(): Boolean {
        if (patientName.text.isEmpty() ||
            dateField.text.isEmpty() ||
            timeField.text.isEmpty() ||
            symptomField.text.isEmpty()
        ) {
            Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun generateAppointmentId(): String {
        return "QS" + System.currentTimeMillis().toString().takeLast(6)
    }

    private fun saveAppointment(
        id: String,
        patient: String,
        doctor: String,
        date: String,
        time: String,
        symptoms: String
    ) {
        val sharedPref = getSharedPreferences("QuickSlot", MODE_PRIVATE)
        val existing = sharedPref.getString("appointments", "") ?: ""

        val newAppointment =
            "$id|$patient|$doctor|$date|$time|$symptoms|Confirmed"

        val updated =
            if (existing.isEmpty()) newAppointment else "$existing;;$newAppointment"

        sharedPref.edit().putString("appointments", updated).apply()
    }

    private fun navigateToConfirmation(
        id: String,
        patient: String,
        date: String,
        time: String,
        symptoms: String
    ) {
        val intent = Intent(this, ConfirmationActivity::class.java).apply {
            putExtra("appointmentId", id)
            putExtra("name", doctorName)
            putExtra("speciality", speciality)
            putExtra("experience", experience)
            putExtra("image", image)
            putExtra("patient", patient)
            putExtra("date", date)
            putExtra("time", time)
            putExtra("symptoms", symptoms)
        }

        startActivity(intent)
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
        finish()
    }
}