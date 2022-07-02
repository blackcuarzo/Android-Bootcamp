package com.danielcano.imdbapp.datalayer.repositories

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.danielcano.imdbapp.datalayer.databases.User
import com.danielcano.imdbapp.datalayer.databases.UserDatabase

class UserRepositoryImpl() : UserRepository {
    private var context = ApplicationProvider.getApplicationContext<Context>()
    private val database = Room.inMemoryDatabaseBuilder(context, UserDatabase::class.java).build()

    override fun addUserToDataBase(user: User) {
        database.userDao().addUser(user)
    }

    override fun getUser(userMail: String): User? {
        return database.userDao().getUserByEmail(userMail)
    }
}