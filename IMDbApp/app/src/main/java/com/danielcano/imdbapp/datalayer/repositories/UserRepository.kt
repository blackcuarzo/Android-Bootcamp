package com.danielcano.imdbapp.datalayer.repositories

import com.danielcano.imdbapp.datalayer.databases.User

interface UserRepository {
    fun addUserToDataBase(user: User)
    fun getUser(userMail: String): User?
}