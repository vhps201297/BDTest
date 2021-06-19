package com.example.bdtest.room

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.bdtest.Constants
import com.example.bdtest.R
import com.example.bdtest.room.bd.entity.Task

class RoomTasksActivity : AppCompatActivity(), TestRoom.View{

    private lateinit var presenter: TestRoom.Presenter
    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var linearNoTasks: LinearLayout
    //private var listenerGetTasks: TestRoom.ListenerGetTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_tasks)
        initializer()
        pruebaDatos()
    }
    fun pruebaDatos(){
        addTask(Task(1, 1,"Tarea 1", false, "Tarea x para x cosa","12/12/!2"))
        addTask(Task(2, 2,"Tarea 2", false, "Tarea x para x cosa","12/12/!2"))
        addTask(Task(2, 3,"Tarea 3", false, "Tarea x para x cosa","12/12/!2"))

    }
    fun initializer(){
        linearNoTasks = findViewById(R.id.linear_without_tasks)
        recyclerView = findViewById(R.id.rv_tasks)
        presenter = TasksPresenter(this, TasksInteractor())
        recyclerView.setHasFixedSize(true)
        //recyclerView.layoutManager = LinearLayoutManager(this) // Se reemplazó por el código del xml
        presenter.setTasksAdapter( object : TestRoom.ListenerGetTask{
            override fun getTasks(tasks: ArrayList<Task>) {
                taskAdapter = TaskAdapter(tasks)
            }
        })
        recyclerView.adapter = taskAdapter
    }
    fun onClickAddTask(view: View) {
        startActivityForResult(Intent(this, AddTaskActivity::class.java), Constants.ADD_TASK_ROOM)

    }
    fun onCLickDeleteAll(view: View) {
        presenter.removeAllTasks()
    }

    override fun addTask(task: Task) {
        presenter.addNewTask(task)
    }

    override fun deleteAllTasks() {
        TODO("Not yet implemented")
    }

    override fun deleteTaskById(id: Int) {
        TODO("Not yet implemented")
    }

    override fun updateTasks() {
        Toast.makeText(this, "Se agregó la tarea correctamente", Toast.LENGTH_SHORT).show()
    }

    override fun showNoTasks() {
        linearNoTasks.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }

    override fun showTasks(tasks: ArrayList<Task>) {

    }

    override fun showDetails() {
        TODO("Not yet implemented")
    }

    override fun showError(err: String) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }

}

