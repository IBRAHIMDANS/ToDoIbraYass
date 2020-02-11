package com.todoibrayass.todo.tasklist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.todoibrayass.todo.R
import com.todoibrayass.todo.task.TaskActivity
import kotlinx.android.synthetic.main.fragment_task_list.*

class TaskListFragment : Fragment() {
    //   private val taskList = listOf("Task 1", "Task 2", "Task 3","Task 1", "Task 2", "Task 3","Task 1", "Task 2", "Task 3")
    lateinit var taskAdapter: TaskListAdapter
    private val taskList = mutableListOf(
        Task(id = "id_1", title = "Task 1", description = "description 1"),
        Task(id = "id_2", title = "Task 2"),
        Task(id = "id_3", title = "Task 3")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler)
        taskAdapter = TaskListAdapter(taskList)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = taskAdapter

        floatingActionButton3.setOnClickListener {
            val intent = Intent(activity, TaskActivity::class.java)
            startActivityForResult(intent, ADD_TASK_REQUEST_CODE)
            /*  taskList.add(
                  Task(
                      id = UUID.randomUUID().toString(),
                      title = "Task ${taskList.size + 1}"
                  )
              )*/
            // taskAdapter.notifyDataSetChanged()

        }
        taskAdapter.onDeleteClickListener = { task ->
            taskList.remove(task)
            taskAdapter.notifyDataSetChanged()
        }
        taskAdapter.onEditClickListener = { task ->
            /*           Log.e("task", task.toString())
                        taskAdapter.notifyDataSetChanged()*/
            val intent = Intent(activity, TaskActivity::class.java)
            intent.putExtra("editTask", task)
            startActivityForResult(intent, EDIT_TASK_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_TASK_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val task = data!!.getSerializableExtra(ADD_TASK_NAME) as Task
            taskList.add(task)
            taskAdapter.notifyDataSetChanged()
        }
        if (requestCode == EDIT_TASK_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val task = data!!.getSerializableExtra(ADD_TASK_NAME) as Task
            var index = taskList.indexOfFirst { it.id == task.id }

            taskList[index] = task
            // taskList.set(index, task)
            taskAdapter.notifyDataSetChanged()
        }
    }

    companion object {
        const val ADD_TASK_REQUEST_CODE = 200
        const val EDIT_TASK_REQUEST_CODE = 201
        const val ADD_TASK_NAME = "myTask"
    }


}
