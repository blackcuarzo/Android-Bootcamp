package com.danielcano.imdbapp.domainlayer.usecases

import com.danielcano.imdbapp.datalayer.databases.User
import com.danielcano.imdbapp.datalayer.repositories.UserRepository

class UserValidationUseCaseImpl(private val userRepository: UserRepository) :
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