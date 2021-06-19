package com.example.bdtest.room.bd.dao

import androidx.room.Dao
import com.example.bdtest.room.bd.entity.Task
import com.example.bdtest.room.bd.entity.User

@Dao
interface UserDao {
    fun getAllTasks(): ArrayList<Task>
    fun getData(): User
    fun getName(): String
    fun getLastName(): String
    fun getPassword(): String
}