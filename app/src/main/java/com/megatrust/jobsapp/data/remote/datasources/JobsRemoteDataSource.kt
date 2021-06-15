package com.megatrust.jobsapp.data.remote.datasources

import arrow.core.Either
import com.megatrust.jobsapp.data.remote.mappers.toJob
import com.megatrust.jobsapp.data.remote.service.JobsService
import com.megatrust.jobsapp.ui.home.Job

class JobsRemoteDataSource(
    private val service: JobsService
) : IJobsRemoteDataSource {
    override
    suspend fun fetch(): Either<String?, List<Job>> {
        return try {
            val list = service.fetchJobs().mapNotNull {
                it.toJob()
            }
            Either.right(list)
        } catch (e: Exception) {
            Either.left(e.message)
        }
    }
}