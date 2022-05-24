package com.danielcano.imdbapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.concurrent.timerTask

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val guestLink = findViewById<TextView>(R.id.guest_link)
        guestLink.movementMethod = LinkMovementMethod.getInstance()

        val registrationLink = findViewById<TextView>(R.id.registration_link)
        registrationLink.movementMethod = LinkMovementMethod.getInstance()

//        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))


        val buttonLogin  = findViewById<Button>(R.id.login_button)
//        buttonLogin.setOnClickListener { startActivity(webIntent)  }


//        Temporal call for SearchActivity
        val searchIntent = Intent(this,SearchActivity::class.java)
        buttonLogin.setOnClickListener { startActivity(searchIntent)  }



    }
}