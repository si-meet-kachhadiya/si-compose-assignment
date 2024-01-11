package com.si_assesment_task_compose.model.MatchDetail


import com.google.gson.annotations.SerializedName

data class FallofWicket(
    @SerializedName("Batsman")
    val batsman: String?,
    @SerializedName("Overs")
    val overs: String?,
    @SerializedName("Score")
    val score: String?
)