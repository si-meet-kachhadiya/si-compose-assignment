package com.si_assesment_task_compose.model.MatchDetail


import com.google.gson.annotations.SerializedName

data class Batting(
    @SerializedName("Average")
    val average: String?,
    @SerializedName("Runs")
    val runs: String?,
    @SerializedName("Strikerate")
    val strikerate: String?,
    @SerializedName("Style")
    val style: String?
)