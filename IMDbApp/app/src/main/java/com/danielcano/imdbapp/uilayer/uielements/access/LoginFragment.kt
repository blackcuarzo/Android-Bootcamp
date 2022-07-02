package com.danielcano.imdbapp.uilayer.uielements.access

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.danielcano.imdbapp.uilayer.AccessNavigator
import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var navigator: AccessNavigator
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigator = context as AccessNavigator
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        val view = binding.root

        // Code goes here
        val guestLink = binding.guestLink
        guestLink.setOnClickListener {

            navigator.navigateToRegistration(it)
        }

        val registrationLink = binding.registrationLink
        registrationLink.setOnClickListener {
            navigator.navigateToRegistration(it)
        }

        val buttonLogin = binding.loginButton
        buttonLogin.setOnClickListener {
            navigator.navigateToMenu()
        }

        return view
    }

}