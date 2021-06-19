package com.example.bdtest.room

import com.example.bdtest.room.bd.entity.Task

class TasksPresenter(view: RoomTasksActivity, interactor: TasksInteractor): TestRoom.Presenter {
    private var view: TestRoom.View = view
    private var interactor: TestRoom.Interactor = interactor

    override fun setTasksAdapter(listener: TestRoom.ListenerGetTask) {
        val tasks = interactor.getAllTasks()
        listener.getTasks(tasks)
    }

    override fun showTasks() {
        TODO("Not yet implemented")
    }

    override fun removeTask(id: Int) {
        TODO("Not yet implemented")
    }

    override fun removeAllTasks() {

    }

    override fun addNewTask(task: Task) {
        interactor.addTask(task, object: TestRoom.AddTaskListener{
            override fun onFinish(isAddTask: Boolean) {
                if (!isAddTask){
                    view.showError("Error al agregar la tarea")
                } else{
                    view.updateTasks()
                }
            }
        })

    }

}