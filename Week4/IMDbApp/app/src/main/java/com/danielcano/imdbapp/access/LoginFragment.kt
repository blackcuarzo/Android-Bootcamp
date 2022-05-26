package com.danielcano.imdbapp.access

import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.SearchActivity

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        // Code goes here

        val guestLink = view.findViewById<TextView>(R.id.guest_link)
        guestLink.movementMethod = LinkMovementMethod.getInstance()

        val registrationLink = view.findViewById<TextView>(R.id.registration_link)
        registrationLink.movementMethod = LinkMovementMethod.getInstance()

        val buttonLogin  = view.findViewById<Button>(R.id.login_button)

        //Temporal call for SearchActivity
        val searchIntent = Intent(requireContext(), SearchActivity::class.java)
        buttonLogin.setOnClickListener { startActivity(searchIntent)  }

        return view
    }

}