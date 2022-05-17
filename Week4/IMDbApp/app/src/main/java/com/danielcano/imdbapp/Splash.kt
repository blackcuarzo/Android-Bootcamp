package com.danielcano.imdbapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.concurrent.timerTask

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginIntent = Intent(this,Login::class.java)
        Timer().schedule(timerTask { startActivity(loginIntent) },3000)

    }

    override fun onResume() {
        super.onResume()
    }
}