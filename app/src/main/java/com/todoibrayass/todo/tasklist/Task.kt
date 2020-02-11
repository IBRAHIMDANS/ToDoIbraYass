package com.todoibrayass.todo.tasklist

import java.io.Serializable

// @Parcelize
data class Task(var id: String, var title: String, var description: String = "desciption default"): Serializable