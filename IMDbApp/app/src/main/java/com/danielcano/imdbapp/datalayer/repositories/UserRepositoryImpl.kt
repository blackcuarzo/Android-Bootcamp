package com.danielcano.imdbapp.datalayer.repositories

import com.danielcano.imdbapp.datalayer.databases.Database
import com.danielcano.imdbapp.datalayer.databases.User

class UserRepositoryImpl() : UserRepository {

    override fun addUserToDataBase(user: User) {
        Database.instance.userDao().addUser(user)
    }

    override fun getUser(userMail: String): User? {
        return Database.instance.userDao().getUserByEmail(userMail)
    }
}