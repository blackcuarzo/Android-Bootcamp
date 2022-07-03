package com.danielcano.imdbapp

import android.app.Application
import com.danielcano.imdbapp.datalayer.databases.UserDatabase

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        UserDatabase.getInstance(this)
    }
}