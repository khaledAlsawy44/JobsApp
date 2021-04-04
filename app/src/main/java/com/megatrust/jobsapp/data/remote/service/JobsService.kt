package com.megatrust.jobsapp.data.remote.service

import com.megatrust.jobsapp.data.remote.entites.JobResponse
import retrofit2.http.GET

interface JobsService {
    @GET("positions.json?description=api")
    suspend fun fetchJobs(): List<JobResponse>
}