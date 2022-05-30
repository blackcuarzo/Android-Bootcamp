package com.danielcano.imdbapp

import android.view.View

interface AccessNavigator {
    fun navigateToRegistration(view: View)
    fun navigateToLogin()
    fun navigateToMenu()
}