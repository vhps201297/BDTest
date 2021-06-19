package com.example.bdtest.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bdtest.R
import com.example.bdtest.room.bd.entity.Task

class TaskAdapter(private var tasks: ArrayList<Task>): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.txvName.text = tasks[position].nameTask
        holder.txvDescription.text = tasks[position].description
        holder.txvFinalizedDate.text = tasks[position].dateFinished
        holder.checkbox.isChecked = tasks[position].isCheck

    }

    override fun getItemCount(): Int {
        return this.tasks.size
    }

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var checkbox: CheckBox = itemView.findViewById(R.id.checkbox_task)
        var txvName: TextView = itemView.findViewById(R.id.txt_task_title)
        var txvDescription: TextView = itemView.findViewById(R.id.txt_description_task)
        var txvFinalizedDate: TextView = itemView.findViewById(R.id.txt_date_finalized)
    }
}