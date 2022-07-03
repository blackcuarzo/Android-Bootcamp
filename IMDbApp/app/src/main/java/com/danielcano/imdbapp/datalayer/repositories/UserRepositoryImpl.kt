package com.danielcano.imdbapp.datalayer.repositories

import com.danielcano.imdbapp.datalayer.databases.User
import com.danielcano.imdbapp.datalayer.databases.UserDatabase

class UserRepositoryImpl() : UserRepository {

    override suspend fun addUserToDataBase(user: User) {
        
        UserDatabase.getInstance().userDao().addUser(user)
//        UserDatabase.getInstance(MyApplication).userDao().addUser(user)
    }

    override suspend fun getUser(userMail: String): User? {
        return UserDatabase.getInstance().userDao().getUserByEmail(userMail)
//        return UserDatabase.getInstance(ApplicationProvider.getApplicationContext()).userDao().getUserByEmail(userMail)
    }
}