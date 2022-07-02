package com.danielcano.imdbapp

import com.danielcano.imdbapp.datalayer.databases.User

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

class UserValidationUseCaseImpl(val userRepository: UserRepository) :
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
    fun getUsers(): List<User>
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

    override fun getUsers(): List<User> {
        return userList
    }
}

class UserRepositoryImpl : UserRepository {
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

    override fun getUsers(): List<User> {
        return userList
    }
}