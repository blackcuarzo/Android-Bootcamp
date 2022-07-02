package com.danielcano.imdbapp.uilayer.viewmodels

import androidx.lifecycle.ViewModel

class UserRegistrationViewModel: ViewModel() {
    fun registerOrValidateUser(name: String, mail: String, pass: String):Boolean {
        return when{
            name.isNullOrEmpty() -> false
            mail.isNullOrEmpty() -> false
            pass.isNullOrEmpty() -> false
            else -> true//Create User and return true
        }
    }
}