package com.example.quickslot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class AppointmentAdapter(
    private val list: MutableList<Appointment>,
    private val onCancel: (Int) -> Unit
) : RecyclerView.Adapter<AppointmentAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvId: TextView = view.findViewById(R.id.tvId)
        val tvDoctor: TextView = view.findViewById(R.id.tvDoctor)
        val tvPatient: TextView = view.findViewById(R.id.tvPatient)
        val tvDate: TextView = view.findViewById(R.id.tvDate)
        val tvTime: TextView = view.findViewById(R.id.tvTime)
        val tvSymptoms: TextView = view.findViewById(R.id.tvSymptoms)
        val tvStatus: TextView = view.findViewById(R.id.tvStatus)
        val btnCancel: Button = view.findViewById(R.id.btnCancel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_appointment, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val appt = list[position]

        holder.tvId.text = "ID: ${appt.id}"
        holder.tvDoctor.text = appt.doctor
        holder.tvPatient.text = "Patient: ${appt.patient}"
        holder.tvDate.text = "Date: ${appt.date}"
        holder.tvTime.text = "Time: ${appt.time}"
        holder.tvSymptoms.text = "Symptoms: ${appt.symptoms}"
        holder.tvStatus.text = appt.status

        holder.btnCancel.setOnClickListener {
            onCancel(position)
        }
    }

    override fun getItemCount(): Int = list.size
}