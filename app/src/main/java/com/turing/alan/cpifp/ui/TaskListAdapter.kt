package com.turing.alan.cpifp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.turing.alan.cpifp.data.Task
import com.turing.alan.cpifp.databinding.TaskListItemBinding

class TaskListAdapter(): ListAdapter<Task, TaskListAdapter.TaskViewHolder>(TaskDiffCallback) {

    class TaskViewHolder(private val binding: TaskListItemBinding) :RecyclerView.ViewHolder(binding.root) {

        init{
            binding.root.setOnClickListener{

            }
        }

        fun bind(task:Task) {
            binding.taskTitle.text = task.title
            binding.taskBody.text = task.body
            binding.taskCompleted.isChecked = task.completed
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding:TaskListItemBinding = TaskListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object TaskDiffCallback: DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Task, newItem: Task) = oldItem.body == newItem.body &&
                oldItem.title == newItem.title &&
                oldItem.completed == newItem.completed

    }

}