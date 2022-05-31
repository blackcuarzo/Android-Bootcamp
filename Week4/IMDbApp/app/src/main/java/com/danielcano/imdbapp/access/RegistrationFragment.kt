package com.danielcano.imdbapp.access

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.danielcano.imdbapp.AccessNavigator
import com.danielcano.imdbapp.R

class RegistrationFragment : Fragment() {

    private lateinit var navigator: AccessNavigator
    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigator = context as AccessNavigator
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_registration, container, false)

        //Code goes here

        val registrationLink = view.findViewById<TextView>(R.id.confirmationButton)
        registrationLink.setOnClickListener{
            navigator.navigateToMenu()
        }
        return view
    }
}