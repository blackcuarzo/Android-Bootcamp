package com.danielcano.imdbapp.uilayer.uielements.menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val navController = findNavController(R.id.nav_host_fragment2)
        val bottomNavigationMenu = binding.bottomNavigationView
        bottomNavigationMenu.setupWithNavController(navController)
    }
}