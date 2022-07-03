package com.danielcano.imdbapp.uilayer.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.danielcano.imdbapp.datalayer.databases.User
import com.danielcano.imdbapp.datalayer.repositories.UserRepositoryImpl
import com.danielcano.imdbapp.domainlayer.usecases.UserValidationUseCaseImpl

class UserRegistrationViewModel : ViewModel() {

    private var userValidationUseCase: UserValidationUseCaseImpl =
        UserValidationUseCaseImpl(UserRepositoryImpl())

    fun registerOrValidateUser(name: String, email: String, pass: String): Boolean {

        return when {
            name.isEmpty() -> false
            email.isEmpty() -> false
            pass.isEmpty() -> false
            else -> {
                try {
                    userValidationUseCase.registerUser(
                        User(
                            name = name,
                            email = email,
                            password = pass
                        )
                    )
                } catch (e: Exception) {
                    Log.e("error de userValidationUseCase", e.toString())
                }
                true//Create User and return true
            }
        }
    }
}