package com.danielcano.imdbapp.access

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.danielcano.imdbapp.AccessNavigator
import com.danielcano.imdbapp.R

// In the constructor we set a parameter onRegistrationListener of type anonymous function with Unit(void) return
class LoginFragment(val onRegistrationListener:(view:View)->Unit) : Fragment() {

    private lateinit var navigator:AccessNavigator
    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigator = context as AccessNavigator
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        // Code goes here

        val guestLink = view.findViewById<TextView>(R.id.guest_link)
        guestLink.setOnClickListener {
            navigator.navigateToRegister()
        }
        //We did this in meeting 10, using anonymous functions i don't need to implement interfaces
        val registrationLink = view.findViewById<TextView>(R.id.registration_link)
        registrationLink.setOnClickListener{
            onRegistrationListener(it)
        }

        val buttonLogin  = view.findViewById<Button>(R.id.login_button)
        buttonLogin.setOnClickListener {
            navigator.navigateToRegister()
        }

        return view
    }

}