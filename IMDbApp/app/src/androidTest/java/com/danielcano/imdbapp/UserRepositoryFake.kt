package com.danielcano.imdbapp

import com.danielcano.imdbapp.datalayer.databases.User
import com.danielcano.imdbapp.datalayer.repositories.UserRepository

class UserRepositoryFake : UserRepository {
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