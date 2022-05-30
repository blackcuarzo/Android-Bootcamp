package com.danielcano.imdbapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.danielcano.imdbapp.access.LoginFragmentDirections
import com.danielcano.imdbapp.access.RegistrationFragmentDirections

class UserAccessActivity : AppCompatActivity(), AccessNavigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_access)

        val navController = findNavController(R.id.nav_host_access_fragment)
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
//        view.findNavController().navigate(action)
        findNavController(R.id.nav_host_access_fragment).navigate(action)
        findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar).setBackgroundColor(getColor(R.color.white))
    }

    override fun navigateToLogin() {
        val action = RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment()
        findNavController(R.id.nav_host_access_fragment).navigate(action)
//        findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar).setBackgroundColor(androidx.appcompat.R.attr.colorPrimary)
    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_access_fragment)
        return when(navController.currentDestination?.id){
            R.id.registrationFragment ->{
                findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar).setBackgroundColor(androidx.appcompat.R.attr.colorPrimary)
                true
            }
            else -> navController.navigateUp()
        }
    }


}