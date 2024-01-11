package com.si_assesment_task_compose.model.MatchDetail


import com.google.gson.annotations.SerializedName

data class BatsmenX(
    @SerializedName("Balls")
    val balls: String?,
    @SerializedName("Batsman")
    val batsman: String?,
    @SerializedName("Runs")
    val runs: String?
)