package com.example.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class User(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val firstName: String,
    @ColumnInfo(name = "lastname") val lastName: String
)
