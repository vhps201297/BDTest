package com.example.bdtest.room.bd.dao

import androidx.room.*
import com.example.bdtest.room.bd.entity.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    fun getAllTasks(): List<Task>
    @Query("SELECT * FROM task WHERE id = :id")
    fun getTaskById(id: Int)
    @Insert
    fun addTask(task: Task)
    @Update
    fun updateTasks()
    @Delete
    fun removeTask(task: Task)

}