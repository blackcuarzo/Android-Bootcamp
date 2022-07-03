package com.danielcano.imdbapp.datalayer.repositories

import android.service.autofill.UserData
import androidx.test.core.app.ApplicationProvider
import com.danielcano.imdbapp.datalayer.databases.Database
import com.danielcano.imdbapp.datalayer.databases.User
import com.danielcano.imdbapp.datalayer.databases.UserDatabase

class UserRepositoryImpl() : UserRepository {

    override fun addUserToDataBase(user: User) {
        UserDatabase.getInstance(ApplicationProvider.getApplicationContext()).userDao().addUser(user)
    }

    override fun getUser(userMail: String): User? {
        return UserDatabase.getInstance(ApplicationProvider.getApplicationContext()).userDao().getUserByEmail(userMail)
    }
}