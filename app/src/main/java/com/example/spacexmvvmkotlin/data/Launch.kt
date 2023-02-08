package com.example.spacexmvvmkotlin.data

data class Launch (
    val mission_name: String,
    val launch_date_utc: String,
    val rocket: Rocket,
    val links: Link,
)


data class Rocket (
    val rocket_name: String
)
data class Link(
    val mission_patch_small: String
)