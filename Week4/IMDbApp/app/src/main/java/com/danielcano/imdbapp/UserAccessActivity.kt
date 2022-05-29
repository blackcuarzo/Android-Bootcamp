package com.danielcano.imdbapp

import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.danielcano.imdbapp.access.LoginFragmentDirections
import com.danielcano.imdbapp.access.RegistrationFragmentDirections

class UserAccessActivity : AppCompatActivity(), AccessNavigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_access)

        val navControler = findNavController(R.id.nav_host_access_fragment)
        val appBarConfiguration = AppBarConfiguration(navControler.graph)
        findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar).setupWithNavController(navControler,appBarConfiguration)
    }

    override fun navigateToRegistration(view:View) {
        val action = LoginFragmentDirections.actionLoginFragmentToRegistrationFragment()
        view.findNavController().navigate(action)
    }

    override fun navigateToLogin() {
        val action = RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment()
        findNavController(R.id.nav_host_access_fragment).navigate(action)
    }


}