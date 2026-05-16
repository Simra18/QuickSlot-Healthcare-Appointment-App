package com.example.quickslot

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class MyAppointmentsActivity : AppCompatActivity() {

    private val list = mutableListOf<Appointment>()
    private lateinit var recycler: RecyclerView
    private lateinit var emptyLayout: LinearLayout
    private lateinit var adapter: AppointmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_appointments)

        setupToolbar()
        initViews()
        loadAppointments()
        setupRecycler()
        updateUI()
        setupButtons()
    }

    private fun setupToolbar() {
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            goHome()
        }
    }

    private fun initViews() {
        recycler = findViewById(R.id.recyclerAppointments)
        emptyLayout = findViewById(R.id.emptyLayout)

        recycler.layoutManager = LinearLayoutManager(this)
    }

    private fun setupRecycler() {
        adapter = AppointmentAdapter(list) { position ->

            AlertDialog.Builder(this)
                .setTitle("Cancel Appointment")
                .setMessage("Are you sure you want to cancel this appointment?")
                .setPositiveButton("Yes") { _, _ ->

                    list.removeAt(position)
                    saveAppointments()
                    adapter.notifyItemRemoved(position)
                    updateUI()

                    Toast.makeText(this, "Appointment Cancelled", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No", null)
                .show()
        }

        recycler.adapter = adapter
    }

    private fun loadAppointments() {
        val pref = getSharedPreferences("QuickSlot", MODE_PRIVATE)
        val data = pref.getString("appointments", "") ?: ""

        list.clear()

        if (data.isNotEmpty()) {
            val entries = data.split(";;")

            for (entry in entries) {
                val p = entry.split("|")
                if (p.size == 7 && p[6] != "Cancelled") {
                    list.add(
                        Appointment(
                            p[0], // id
                            p[1], // patient
                            p[2], // doctor
                            p[3], // date
                            p[4], // time
                            p[5], // symptoms
                            p[6]  // status
                        )
                    )
                }
            }
        }
    }

    private fun saveAppointments() {
        val pref = getSharedPreferences("QuickSlot", MODE_PRIVATE)

        val updated = list.joinToString(";;") {
            "${it.id}|${it.patient}|${it.doctor}|${it.date}|${it.time}|${it.symptoms}|${it.status}"
        }

        pref.edit().putString("appointments", updated).apply()
    }

    private fun updateUI() {
        if (list.isEmpty()) {
            emptyLayout.visibility = View.VISIBLE
            recycler.visibility = View.GONE
        } else {
            emptyLayout.visibility = View.GONE
            recycler.visibility = View.VISIBLE
        }
    }

    private fun setupButtons() {
        val btnBook = findViewById<Button>(R.id.btnBook)
        val btnHome = findViewById<Button>(R.id.btnHome)

        btnBook.setOnClickListener {
            startActivity(Intent(this, DoctorListActivity::class.java))
        }

        btnHome.setOnClickListener {
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