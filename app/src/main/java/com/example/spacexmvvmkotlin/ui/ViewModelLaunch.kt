package com.example.spacexmvvmkotlin.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexmvvmkotlin.data.Launch
import com.example.spacexmvvmkotlin.repository.LaunchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelLaunch @Inject constructor(private val repository: LaunchRepository) : ViewModel() {


        private val _launches = MutableLiveData<List<Launch>>()
        val launches: LiveData<List<Launch>>
            get() = _launches

        fun fetchLaunches() {
            viewModelScope.launch {
                try {
                    val launches = repository.getLaunches()
                    _launches.value = launches
                } catch (e: Exception) {
                    // handle error

                }
            }
        }
    }
