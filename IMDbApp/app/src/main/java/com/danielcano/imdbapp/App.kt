package com.danielcano.imdbapp

import android.app.Application
import android.content.Context
import com.danielcano.imdbapp.datalayer.databases.UserDatabase

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        App.setContext(this)
    }

    companion object {
        private lateinit var application: Application

        private fun setContext(app: App) {
            App.application = app
        }
        fun getContext():Context{
            return application
        }
    }
}