package com.megatrust.jobsapp.data.remote.datasources

import arrow.core.Either
import com.megatrust.jobsapp.ui.home.Job

interface IJobsRemoteDataSource {
    suspend fun fetch(): Either<String?, List<Job>>
}