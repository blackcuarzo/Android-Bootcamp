package com.danielcano.imdbapp.datalayer.databases

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAllUsers():List<User>

    @Query("SELECT * FROM user WHERE email LIKE :mail")
    fun getUserByEmail(mail:String):User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user:User)
}
