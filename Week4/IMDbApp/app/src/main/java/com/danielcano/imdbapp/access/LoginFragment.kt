package com.danielcano.imdbapp.access

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danielcano.imdbapp.R

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        // Code goes here

        val guestLink = findViewById<TextView>(R.id.guest_link)
        guestLink.movementMethod = LinkMovementMethod.getInstance()

        val registrationLink = findViewById<TextView>(R.id.registration_link)
        registrationLink.movementMethod = LinkMovementMethod.getInstance()

        val buttonLogin  = findViewById<Button>(R.id.login_button)

        Temporal call for SearchActivity
        val searchIntent = Intent(this,SearchActivity::class.java)
        buttonLogin.setOnClickListener { startActivity(searchIntent)  }

        return view
    }

}