package com.si_assesment_task_compose.model.MatchDetail


import com.google.gson.annotations.SerializedName

data class Officials(
    @SerializedName("Referee")
    val referee: String?,
    @SerializedName("Umpires")
    val umpires: String?
)