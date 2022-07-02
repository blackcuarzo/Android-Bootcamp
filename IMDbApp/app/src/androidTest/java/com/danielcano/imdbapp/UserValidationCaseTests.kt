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
class UserValidationCaseTests {
    private lateinit var userDatabase: UserDatabase

//    @Before
//    fun setUpDatabase() {
//        var context = ApplicationProvider.getApplicationContext<Context>()
//        userDatabase = Room.inMemoryDatabaseBuilder(context, UserDatabase::class.java).build()
//    }

    @Before
    fun setUpDatabase() {
        var context = ApplicationProvider.getApplicationContext<Context>()
        userDatabase = Room.inMemoryDatabaseBuilder(context, UserDatabase::class.java).build()
    }

    @Test
    fun userRepository_getUser_userMail_success(){
        val userRepository = UserRepositoryImpl()
        val user = User(email = "carlos.gmail.com", name = "carlos", password = "1234")
        userRepository.addUserToDataBase(user)
        assert(userRepository.getUser(user.email)!!.email == user.email)
    }

    @Test
    fun userValidationUseCase_registerUser_success(){
        val userValidationUseCase = UserValidationUseCaseImpl(UserRepositoryImpl())
        val user1 = User(name = "Carlos", email = "carlos@gmail.com", password = "12345")
        val user2 = User(name = "Juan", email = "juan@gmail.com", password = "123")
        userValidationUseCase.registerUser(user1)
        userValidationUseCase.registerUser(user2)
        assert(user2 == userValidationUseCase.userRepository.getUser(user2.email))
    }

    @Test
    fun userValidationUseCase_validateUser_userMailAndUserPass_success(){
        val userValidationUseCase = UserValidationUseCaseImpl(UserRepositoryImpl())
        val user1 = User(name = "Carlos", email = "carlos@gmail.com", password = "12345")
        val user2 = User(name = "Juan", email = "juan@gmail.com", password = "123")
        userValidationUseCase.registerUser(user1)
        userValidationUseCase.registerUser(user2)
        assert(userValidationUseCase.validateUser(userMail = "carlos@gmail.com", userPass = "12345"))
    }

    @Test
    fun userValidationUseCase_validateUser_fail(){
        val userValidationUseCase = UserValidationUseCaseImpl(UserRepositoryImpl())
        val user1 = User(name = "Carlos", email = "carlos@gmail.com", password = "12345")
        val user2 = User(name = "Juan", email = "juan@gmail.com", password = "123")
        userValidationUseCase.registerUser(user1)
        userValidationUseCase.registerUser(user2)
        assert(!userValidationUseCase.validateUser("juan@gmail.com","12345"))
    }


}