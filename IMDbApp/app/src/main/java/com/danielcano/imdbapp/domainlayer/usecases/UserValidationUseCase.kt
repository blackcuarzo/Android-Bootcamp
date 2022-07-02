package com.danielcano.imdbapp.domainlayer.usecases

import com.danielcano.imdbapp.datalayer.databases.User

interface UserValidationUseCase {
    fun registerUser(user: User)
    fun validateUser(userMail: String, userPass: String): Boolean
}