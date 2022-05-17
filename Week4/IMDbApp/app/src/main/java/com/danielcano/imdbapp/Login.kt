package com.danielcano.imdbapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.TextView

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        val guestLink = findViewById<TextView>(R.id.guest_link)
        guestLink.movementMethod = LinkMovementMethod.getInstance()

        val registrationLink = findViewById<TextView>(R.id.registration_link)
        registrationLink.movementMethod = LinkMovementMethod.getInstance()

        val abrirNavegador = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))


        val buttonLogin  = findViewById<Button>(R.id.login_button)
        buttonLogin.setOnClickListener { startActivity(abrirNavegador)  }
    }
}