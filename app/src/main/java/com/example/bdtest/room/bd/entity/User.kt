package com.example.bdtest.room.bd.entity

import androidx.room.PrimaryKey


data class User(
    @PrimaryKey(autoGenerate = true) val idUser: Int,
    var name: String,
    val lastName: String,
    var tasks: ArrayList<Task>,
    val password: String
)
