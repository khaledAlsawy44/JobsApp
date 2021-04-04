package com.megatrust.jobsapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.megatrust.jobsapp.R
import com.megatrust.jobsapp.databinding.JobItemLayoutBinding

class JobsAdapter(
    private val onJobClicked: (job: Job) -> Unit
) : ListAdapter<Job, JobsAdapter.ViewHolder>(
    DiffCallback()
) {

    class ViewHolder(
        private val binding: JobItemLayoutBinding,
        private val onJobClicked: (job: Job) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindTo(job: Job) = with(binding) {
            companyNameTv.text = job.companyName
            jobTitleTv.text = job.title
            jobTypeTv.text = job.type ?: ""
            companyLogoIv.load(job.companyLogo) {
                placeholder(R.drawable.job_dream)
                fallback(R.drawable.job_dream)
            }
            root.setOnClickListener { onJobClicked(job) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = JobItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding, onJobClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }
}

class DiffCallback : DiffUtil.ItemCallback<Job>() {

    override fun areItemsTheSame(
        oldItem: Job,
        newItem: Job
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Job,
        newItem: Job
    ): Boolean {
        return oldItem == newItem
    }
}
