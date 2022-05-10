package com.danielcano.firstapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import java.util.*
import kotlin.concurrent.timerTask

class Temporizer : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show()
        val tempo = Timer()
        val timeInSeconds = intent?.getStringExtra("setTime")?.toLong()?.times(1000) ?:3000
        val message = Toast.makeText(this, "Counted ${timeInSeconds/1000} seconds", Toast.LENGTH_SHORT)
        tempo.schedule(timerTask { message.show()},timeInSeconds)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Toast.makeText(this, "Service was destroyed", Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }
}