package com.danielcano.imdbapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.TextView
import com.danielcano.imdbapp.access.LoginFragment

class UserAccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_access)
        val guestLink = findViewById<TextView>(R.id.guest_link)
        guestLink.movementMethod = LinkMovementMethod.getInstance()

        val registrationLink = findViewById<TextView>(R.id.registration_link)
        registrationLink.movementMethod = LinkMovementMethod.getInstance()

        val buttonLogin  = findViewById<Button>(R.id.login_button)

//        Temporal call for SearchActivity
        val searchIntent = Intent(this,SearchActivity::class.java)
        buttonLogin.setOnClickListener { startActivity(searchIntent)  }

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer,LoginFragment())
            .commit()
    }
}