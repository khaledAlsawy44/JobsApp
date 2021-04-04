package com.megatrust.jobsapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.megatrust.jobsapp.data.remote.datasources.IJobsRemoteDataSource
import kotlinx.coroutines.launch

class HomeViewModel(
    private val remoteDataSource: IJobsRemoteDataSource
) : ViewModel() {

    private val _stateLiveData: MutableLiveData<HomeState> = MutableLiveData(HomeState.Loading)
    val stateLiveData: LiveData<HomeState> = _stateLiveData

    init {
        viewModelScope.launch {
            when (val jobsResult = remoteDataSource.fetch()) {
                is Either.Left -> _stateLiveData.value = HomeState.Error(jobsResult.a ?: "")
                is Either.Right -> _stateLiveData.value = HomeState.Success(jobsResult.b)
            }
        }
    }
}