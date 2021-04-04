package com.megatrust.jobsapp.di

import com.megatrust.jobsapp.data.remote.datasources.IJobsRemoteDataSource
import com.megatrust.jobsapp.data.remote.datasources.JobsRemoteDataSource
import com.megatrust.jobsapp.data.remote.service.JobsService
import com.megatrust.jobsapp.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val jobsModule = module {
    viewModel { HomeViewModel(get()) }
    single<IJobsRemoteDataSource> { JobsRemoteDataSource(get()) }
    single { createJobsService(get()) }
}

fun createJobsService(retrofit: Retrofit): JobsService {
    return retrofit.create(JobsService::class.java)
}
