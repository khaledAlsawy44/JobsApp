package com.megatrust.jobsapp.ui.home


sealed class HomeState {
    object Loading : HomeState()
    data class Error(val errorMessage: String) : HomeState()
    data class Success(val jobsList: List<Job>) : HomeState()
}

data class Job(
    val id: String,
    val companyName: String,
    val companyLogo: String?,
    val companyUrl: String?,
    val createdAt: String?,
    val description: String,
    val howToApply: String?,
    val location: String?,
    val title: String,
    val type: String?,
    val url: String?
)