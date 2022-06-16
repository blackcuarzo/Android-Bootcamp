package com.danielcano.imdbapp.uilayer

import android.view.View

interface AccessNavigator {
    fun navigateToRegistration(view: View)
    fun navigateToLogin()
    fun navigateToMenu()
}