package com.danielcano.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this,"Creating app",Toast.LENGTH_SHORT).show()
        Log.d("LifeCycleMessages", "onCreate: App Created")
        val startButton:Button = findViewById(R.id.start_service_button)
        val seconds:EditText = findViewById(R.id.seconds_field)
        startButton.setOnClickListener { startService(Intent(this,Temporizer::class.java).putExtra("setTime",seconds.text.toString())) }

    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"Starting App",Toast.LENGTH_SHORT).show()
        Log.d("LifeCycleMessages", "onStart: App Started")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"Resume stage",Toast.LENGTH_SHORT).show()
        Log.d("LifeCycleMessages", "onResume: App Resumed")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "App Paused", Toast.LENGTH_SHORT).show()
        Log.d("LifeCycleMessages", "onPause: App Paused")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "App Stopped", Toast.LENGTH_SHORT).show()
        Log.d("LifeCycleMessages", "onStop: App Stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "App Destroyed", Toast.LENGTH_SHORT).show()
        Log.d("LifeCycleMessages", "onDestroy: App destroyed")
    }
}