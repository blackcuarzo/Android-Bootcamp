package com.danielcano.imdbapp.uilayer.viewmodels

import androidx.lifecycle.ViewModel
import com.danielcano.imdbapp.datalayer.repositories.UserRepositoryImpl
import com.danielcano.imdbapp.domainlayer.usecases.UserValidationUseCaseImpl

class UserRegistrationViewModel : ViewModel() {

    var userValidationUseCase: UserValidationUseCaseImpl = UserValidationUseCaseImpl(UserRepositoryImpl())

    fun registerOrValidateUser(name: String, email: String, pass: String): Boolean {
        return when {
            name.isNullOrEmpty() -> false
            email.isNullOrEmpty() -> false
            pass.isNullOrEmpty() -> false
            else -> {
                true//Create User and return true
            }
        }
    }
}