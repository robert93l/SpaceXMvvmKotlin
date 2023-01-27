package com.example.spacexmvvmkotlin

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