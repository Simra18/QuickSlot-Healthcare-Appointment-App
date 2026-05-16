package com.example.quickslot

data class Appointment(
    val id: String = "",
    val patient: String = "",
    val doctor: String = "",
    val date: String = "",
    val time: String = "",
    val symptoms: String = "",
    val status: String = ""
)