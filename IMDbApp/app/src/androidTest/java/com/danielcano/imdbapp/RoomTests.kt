package com.danielcano.imdbapp

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.danielcano.imdbapp.datalayer.databases.User
import com.danielcano.imdbapp.datalayer.databases.UserDatabase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RoomTests {
    private lateinit var userDatabase: UserDatabase

    @Before
    fun setUpDatabase() {
        var context = ApplicationProvider.getApplicationContext<Context>()
        userDatabase = Room.inMemoryDatabaseBuilder(context, UserDatabase::class.java).build()
    }

    @Test
    fun createAndConsultUser_user_success() {
        val user = User(name = "Daniel", email = "daniel.cano@gmail.com", password = "1234")
        userDatabase.userDao().addUser(user)
        val usuario = userDatabase.userDao().getUserByEmail("daniel.cano@gmail.com")
        assert(usuario.name == "Daniel")
    }

    @Test
    fun checkUserPassword_user_success() {
        val user = User(name = "Carlos", email = "carlos@gmail.com", password = "34512")
        userDatabase.userDao().addUser(user)
        val usuario = userDatabase.userDao().getUserByEmail("carlos@gmail.com")
        assert(usuario.password == "34512")
    }
}