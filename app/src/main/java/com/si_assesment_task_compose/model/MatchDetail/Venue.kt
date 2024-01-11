package com.si_assesment_task_compose.model.MatchDetail


import com.google.gson.annotations.SerializedName

data class Venue(
    @SerializedName("Id")
    val id: String?,
    @SerializedName("Name")
    val name: String?
)