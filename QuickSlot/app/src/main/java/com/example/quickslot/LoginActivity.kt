package com.example.quickslot

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.view.animation.AnimationUtils

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailField = findViewById<EditText>(R.id.emailField)
        val passwordField = findViewById<EditText>(R.id.passwordField)
        val loginButton = findViewById<Button>(R.id.loginButton)

        val anim = AnimationUtils.loadAnimation(this, R.anim.button_click)

        loginButton.setOnClickListener {
            it.startAnimation(anim)

            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            if (email == "dummy@gmail.com" && password == "1234") {

                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
                finish()

            } else {
                Toast.makeText(this, "Invalid Email or Password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}