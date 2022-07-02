package com.danielcano.imdbapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.danielcano.imdbapp.datalayer.databases.User
import com.danielcano.imdbapp.datalayer.databases.UserDatabase
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserValidationCaseFakeTests {
//    private lateinit var userDatabase: UserDatabase

//    @Before
//    fun setUpDatabase() {
//        var context = ApplicationProvider.getApplicationContext<Context>()
//        userDatabase = Room.inMemoryDatabaseBuilder(context, UserDatabase::class.java).build()
//    }

    @Test
    fun userRepository_getUser_userMail_success(){
        val userRepositoryFake = UserRepositoryFakeImpl()
        val user = User(email = "carlos.gmail.com", name = "carlos", password = "1234")
        userRepositoryFake.addUserToDataBase(user)

        assert(userRepositoryFake.getUser(user.email)!!.email == user.email)
    }

    @Test
    fun userValidationUseCase_registerUser_success(){
        val userValidationUseCaseFake = UserValidationUseCaseFakeImpl(UserRepositoryFakeImpl())
        val user1 = User(name = "Carlos", email = "carlos@gmail.com", password = "12345")
        val user2 = User(name = "Juan", email = "juan@gmail.com", password = "123")
        userValidationUseCaseFake.registerUser(user1)
        userValidationUseCaseFake.registerUser(user2)
        assert(user2 == userValidationUseCaseFake.userRepository.getUser(user2.email))
    }

    @Test
    fun userValidationUseCase_validateUser_userMailAndUserPass_success(){
        val userValidationUseCaseFake = UserValidationUseCaseFakeImpl(UserRepositoryFakeImpl())
        val user1 = User(name = "Carlos", email = "carlos@gmail.com", password = "12345")
        val user2 = User(name = "Juan", email = "juan@gmail.com", password = "123")
        userValidationUseCaseFake.registerUser(user1)
        userValidationUseCaseFake.registerUser(user2)
        assert(userValidationUseCaseFake.validateUser(userMail = "carlos@gmail.com", userPass = "12345"))
    }

    @Test
    fun userValidationUseCase_validateUser_fail(){
        val userValidationUseCaseFake = UserValidationUseCaseFakeImpl(UserRepositoryFakeImpl())
        val user1 = User(name = "Carlos", email = "carlos@gmail.com", password = "12345")
        val user2 = User(name = "Juan", email = "juan@gmail.com", password = "123")
        userValidationUseCaseFake.registerUser(user1)
        userValidationUseCaseFake.registerUser(user2)
        assert(!userValidationUseCaseFake.validateUser("juan@gmail.com","12345"))
    }
}