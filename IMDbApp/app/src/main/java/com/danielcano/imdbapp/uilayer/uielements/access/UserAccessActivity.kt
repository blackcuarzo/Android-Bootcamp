package com.danielcano.imdbapp.uilayer.uielements.access

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.uilayer.AccessNavigator

class UserAccessActivity : AppCompatActivity(), AccessNavigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_access)
    }

    override fun navigateToRegistration(view: View) {
        val action = LoginFragmentDirections.actionLoginFragmentToRegistrationFragment()
        view.findNavController().navigate(action)
    }

    override fun navigateToLogin() {
        val action = RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment()
        findNavController(R.id.nav_host_fragment).navigate(action)
    }

    override fun navigateToMenu() {
        findNavController(R.id.nav_host_fragment).navigate(R.id.menuActivity)
    }
}