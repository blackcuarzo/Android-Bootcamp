package com.danielcano.imdbapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loginIntent = Intent(this,Login::class.java)
        startActivity(loginIntent)

    }

    override fun onResume() {
        super.onResume()
    }
}