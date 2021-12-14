package com.example.database


import androidx.room.Dao
import androidx.room.Query

@Dao

interface UserDao {
    @Query("SELECT * FROM students")
    fun getAll(): List<User>

    @Query("SELECT * FROM STUDENTS WHERE ID = (:d) ")
    fun getData(d:Int):User
}