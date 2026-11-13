package com.cristina.task.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cristina.task.R
import com.cristina.task.data.model.Status
import com.cristina.task.data.model.Task
import com.cristina.task.databinding.ItemTaskBinding

class TaskAdapter(
    private val context: Context,
    private val taskSelected: (Task, Int) -> Unit
) : ListAdapter<Task, TaskAdapter.MyViewHolder>(DIFF_CALLBACK) {

    companion object {
        const val SELECT_BACK: Int = 1
        const val SELECT_REMOVE: Int = 2
        const val SELECT_EDIT: Int = 3
        const val SELECT_DETAILS: Int = 4
        const val SELECT_NEXT: Int = 5

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Task>() {
            override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem.id == newItem.id && oldItem.description == newItem.description
            }

            override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val task = getItem(position)

        holder.binding.textDescription.text = task.description

        setIndicator(task, holder)

        holder.binding.buttonBack.setOnClickListener { taskSelected(task, SELECT_BACK) }
        holder.binding.buttonDelete.setOnClickListener { taskSelected(task, SELECT_REMOVE) }
        holder.binding.buttonEditar.setOnClickListener { taskSelected(task, SELECT_EDIT) }
        holder.binding.buttonDetails.setOnClickListener { taskSelected(task, SELECT_DETAILS) }
        holder.binding.buttonForward.setOnClickListener { taskSelected(task, SELECT_NEXT) }
    }

    private fun setIndicator(task: Task, holder: MyViewHolder) {
        when (task.status) {
            Status.TODO -> {
                holder.binding.buttonBack.isVisible = false
                holder.binding.buttonForward.isVisible = true
            }
            Status.DOING -> {
                holder.binding.buttonBack.isVisible = true
                holder.binding.buttonForward.isVisible = true

                holder.binding.buttonBack.setColorFilter(
                    ContextCompat.getColor(context, R.color.color_doing)
                )
                holder.binding.buttonForward.setColorFilter(
                    ContextCompat.getColor(context, R.color.color_done)
                )
            }
            Status.DONE -> {
                holder.binding.buttonBack.isVisible = true
                holder.binding.buttonForward.isVisible = false
            }
        }
    }

    class MyViewHolder(val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root)
}