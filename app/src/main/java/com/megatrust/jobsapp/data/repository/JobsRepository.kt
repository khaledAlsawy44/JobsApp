package com.megatrust.jobsapp.data.repository

import arrow.core.Either
import com.megatrust.jobsapp.data.remote.datasources.IJobsRemoteDataSource
import com.megatrust.jobsapp.ui.home.Job

//class JobsRepository(
//    private val remoteDataSource: IJobsRemoteDataSource
//) : IJobsRepository {
//    override suspend fun fetch(): Either<String?, List<Job>> {
//        return remoteDataSource.fetch()
//    }
//}