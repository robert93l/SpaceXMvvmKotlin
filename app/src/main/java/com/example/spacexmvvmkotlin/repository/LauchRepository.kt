package com.example.spacexmvvmkotlin.repository

import com.example.spacexmvvmkotlin.api.SpaceXApi
import com.example.spacexmvvmkotlin.data.Launch
import javax.inject.Inject


class LaunchRepository @Inject constructor(private val api: SpaceXApi) {

    suspend fun getLaunches(): List<Launch> {
        val response = api.getLaunches()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception("Failed to fetch launches")
        }
    }
}