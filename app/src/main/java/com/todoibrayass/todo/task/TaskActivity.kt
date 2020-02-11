package com.todoibrayass.todo.task

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.todoibrayass.todo.R
import com.todoibrayass.todo.tasklist.Task
import kotlinx.android.synthetic.main.task_activity.*
import java.util.*


class TaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.task_activity)
        val desc = descEditText?.text
        val title = titleEditText?.text
        validateTask.setOnClickListener {
            val sendTask =
                Task(
                    id = UUID.randomUUID().toString(),
                    title = title.toString(),
                    description = desc.toString()
                )
           val intentTask =  intent.putExtra("myTask", sendTask)
            setResult(Activity.RESULT_OK, intentTask)
            finish()
        }
    }

}
