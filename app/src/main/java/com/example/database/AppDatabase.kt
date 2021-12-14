package com.example.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {


    private lateinit var INSTANCE:AppDatabase

    fun getInstance(context: Context):AppDatabase = (
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "users.db"
        )
            .createFromAsset("users.db")
            .allowMainThreadQueries()
            .build()
        )

    abstract fun userDao(): UserDao
}