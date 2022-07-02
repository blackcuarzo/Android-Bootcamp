package com.danielcano.imdbapp

import android.service.autofill.UserData
import androidx.room.Database
import com.danielcano.imdbapp.datalayer.databases.User
import com.danielcano.imdbapp.datalayer.databases.UserDatabase

interface UserValidationUseCase {
    fun registerUser(user: User)
    fun validateUser(userMail: String, userPass: String): Boolean
}

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

interface UserRepository {
    fun addUserToDataBase(user: User)
    fun getUser(userMail: String): User?
}

class UserRepositoryFakeImpl : UserRepository {
    private var userList: MutableList<User> = mutableListOf()

    override fun addUserToDataBase(user: User) {
        userList.add(user)
    }

    override fun getUser(userMail: String): User? {
        userList.forEach { user ->
            if (userMail == user.email) {
                return user
            }
        }
        return null
    }
}

class UserRepositoryImpl(private val database: UserDatabase) : UserRepository {
    private var userList: MutableList<User> = mutableListOf()

    override fun addUserToDataBase(user: User) {
        database.userDao().addUser(user)
    }

    override fun getUser(userMail: String): User? {
        return database.userDao().getUserByEmail(userMail)
    }
}