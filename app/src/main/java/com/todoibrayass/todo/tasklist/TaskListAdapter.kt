package com.todoibrayass.todo.tasklist

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class TaskListAdapter(private val taskList: List<String>) : RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {
    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(taskTitle: String) {
            // C'est ici qu'on reliera les données et les listeners une fois l'adapteur implémenté
        }
    }
}
