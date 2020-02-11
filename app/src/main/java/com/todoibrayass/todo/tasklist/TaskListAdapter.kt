package com.todoibrayass.todo.tasklist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.todoibrayass.todo.R
import kotlinx.android.synthetic.main.item_task.view.*

class TaskListAdapter(private val taskList: List<Task>) :
    RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {

    var onDeleteClickListener: (Task) -> Unit = {  }
    var onEditClickListener: (Task) -> Unit = {  }

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(task: Task) {
            itemView.task_title.text = task.title
            itemView.task_description.text = task.description
            itemView.deleteTask.setOnClickListener {
               onDeleteClickListener.invoke(task)
            }
            itemView.editTask.setOnClickListener {
                onEditClickListener.invoke(task)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(taskList[position])
    }



}

