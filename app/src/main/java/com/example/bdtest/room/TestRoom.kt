package com.example.bdtest.room

import com.example.bdtest.room.bd.entity.Task

interface TestRoom {
    interface View{
        fun addTask(task: Task)
        fun deleteAllTasks()
        fun deleteTaskById(id: Int)
        fun updateTasks()
        fun showNoTasks()
        fun showTasks(tasks: ArrayList<Task>)
        fun showDetails()
        fun showError(err: String)
    }

    interface Presenter{
        fun setTasksAdapter(listener: ListenerGetTask)
        fun showTasks()
        fun removeTask(id: Int)
        fun removeAllTasks()
        fun addNewTask(task: Task)
    }

    interface Interactor{
        fun deleteTasks()
        fun addTask(task: Task,listener: AddTaskListener)
        fun deleteTask(id: Int)
        fun getAllTasks(): ArrayList<Task>
        fun getTask(): Task
    }

    interface ListenerGetTask{
        fun getTasks(tasks: ArrayList<Task>)
    }

    interface AddTaskListener{
        fun onFinish(isAddTask: Boolean)
    }
}