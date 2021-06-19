package com.example.bdtest.room

import com.example.bdtest.room.bd.UserDatabase
import com.example.bdtest.room.bd.entity.Task

class TasksInteractor: TestRoom.Interactor {

    private var tasks: ArrayList<Task>? = null

    override fun deleteTasks() {
        TODO("Not yet implemented")
    }

    override fun addTask(task: Task, listener: TestRoom.AddTaskListener) {

        listener.onFinish(true)
    }

    override fun deleteTask(id: Int) {
        TODO("Not yet implemented")
    }

    override fun getAllTasks(): ArrayList<Task> {
        TODO("Not yet implemented")
    }

    override fun getTask(): Task {
        TODO("Not yet implemented")
    }
}