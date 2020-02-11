package com.todoibrayass.todo.task

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.todoibrayass.todo.R
import com.todoibrayass.todo.tasklist.Task
import kotlinx.android.synthetic.main.task_activity.*
import java.io.Serializable
import java.util.*


class TaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.task_activity)
        val task = intent?.getSerializableExtra("editTask") as? Task
        titleEditText?.setText(task?.title)
        descEditText?.setText(task?.description)
        validateTask.setOnClickListener {
            val sendTask =
                Task(
                    id = task?.id ?: UUID.randomUUID().toString(),
                    title = titleEditText.text.toString(),
                    description = descEditText.text.toString()
                )
            val intentTask = intent.putExtra("myTask", sendTask as Serializable)
            setResult(Activity.RESULT_OK, intentTask)
            finish()
        }
    }

}
