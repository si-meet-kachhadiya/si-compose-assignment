package com.si_assesment_task_compose.model.MatchDetail


import com.google.gson.annotations.SerializedName

data class PowerPlay(
    @SerializedName("PP1")
    val pP1: String?,
    @SerializedName("PP2")
    val pP2: String?
)