package com.danielcano.imdbapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.danielcano.imdbapp.access.LoginFragmentDirections
import com.danielcano.imdbapp.access.RegistrationFragmentDirections

class UserAccessActivity : AppCompatActivity(), AccessNavigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_access)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        //setSupportActionBar(toolbar)
        NavigationUI.setupWithNavController(toolbar, navController,appBarConfiguration)
//        NavigationUI.setupActionBarWithNavController(this, navController,appBarConfiguration)
        //findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar).setupWithNavController(navController,appBarConfiguration)
        toolbar.setNavigationOnClickListener {
            if (navController.currentDestination?.id == R.id.registrationFragment) {
                // Custom behavior here
                toolbar.setBackgroundColor(getColor(R.color.yellow_brand))
                navController.navigateUp()
            } else {
                navController.navigateUp()
            }
        }
    }

    override fun navigateToRegistration(view:View) {
        val action = LoginFragmentDirections.actionLoginFragmentToRegistrationFragment()
        view.findNavController().navigate(action)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.setBackgroundColor(getColor(R.color.white))
    }

    override fun navigateToLogin() {
        val action = RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment()
        findNavController(R.id.nav_host_fragment).navigate(action)
    }

    override fun navigateToMenu() {
        findNavController(R.id.nav_host_fragment).navigate(R.id.menuActivity)

    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return when(navController.currentDestination?.id){
            R.id.registrationFragment ->{
                findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar).setBackgroundColor(androidx.appcompat.R.attr.colorPrimary)
                true
            }
            else -> navController.navigateUp()
        }
    }
}