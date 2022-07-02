package com.danielcano.imdbapp

import com.danielcano.imdbapp.datalayer.databases.User
import com.danielcano.imdbapp.datalayer.repositories.UserRepository
import com.danielcano.imdbapp.domainlayer.usecases.UserValidationUseCase

class UserValidationUseCaseFakeImpl(val userRepository: UserRepository) :
    UserValidationUseCase {

    override fun registerUser(user: User) {
        userRepository.addUserToDataBase(user)
    }

    override fun validateUser(userMail: String, userPass: String): Boolean {
        val user = userRepository.getUser(userMail)
        user?.let {
            if (it.password == userPass) {
                return true
            }
        }
        return false
    }
}

