package com.example.spacexmvvmkotlin

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofit = Retrofit.Builder()
    .baseUrl("https://api.spacexdata.com/v3/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val spaceXRetrofit = retrofit.create(SpaceXApi::class.java)