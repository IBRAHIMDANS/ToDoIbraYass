package com.todoibrayass.todo.tasklist

import java.io.Serializable

data class Task(var id: String, var title: String, var description: String = "desciption default"): Serializable