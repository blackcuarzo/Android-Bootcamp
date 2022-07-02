package com.danielcano.imdbapp.datalayer.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.test.core.app.ApplicationProvider

@Database(entities = [User::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao():UserDao
}

object Database{
    val instance by lazy {
        val context = ApplicationProvider.getApplicationContext<Context>()
        Room.inMemoryDatabaseBuilder(context, UserDatabase::class.java).build()
    }
}