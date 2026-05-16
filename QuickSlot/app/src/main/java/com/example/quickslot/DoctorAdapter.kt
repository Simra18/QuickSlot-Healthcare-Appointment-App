package com.example.quickslot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class DoctorAdapter(
    private val list: List<Doctor>,
    private val onClick: (Doctor) -> Unit
) : RecyclerView.Adapter<DoctorAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.docImage)
        val name: TextView = view.findViewById(R.id.docName)
        val special: TextView = view.findViewById(R.id.docSpecial)
        val exp: TextView = view.findViewById(R.id.docExp)
        val button: Button = view.findViewById(R.id.bookBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_doctor, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val doctor = list[position]

        holder.name.text = doctor.name
        holder.special.text = doctor.speciality
        holder.exp.text = doctor.experience
        holder.image.setImageResource(doctor.image)

        holder.itemView.setOnClickListener {
            onClick(doctor)
        }

        holder.button.setOnClickListener {
            onClick(doctor)
        }
    }

    override fun getItemCount(): Int = list.size
}