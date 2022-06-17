package com.danielcano.imdbapp.uilayer.uielements.menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.danielcano.imdbapp.R

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val navController = findNavController(R.id.nav_host_fragment2)
        val bottomNavigationMenu =
            findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationMenu.setupWithNavController(navController)
    }
}