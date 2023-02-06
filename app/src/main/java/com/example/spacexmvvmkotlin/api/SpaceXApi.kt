package com.example.spacexmvvmkotlin.api




import com.example.spacexmvvmkotlin.data.Launch
import retrofit2.Response
import retrofit2.http.GET


interface SpaceXApi {
    @GET("launches")
   suspend fun getLaunches(): Response<List<Launch>>
}