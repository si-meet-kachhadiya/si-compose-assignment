package com.si_assesment_task_compose.model.MatchDetail


import com.google.gson.annotations.SerializedName

data class TeamInfo(
    @SerializedName("Name_Full")
    val nameFull: String?,
    @SerializedName("Name_Short")
    val nameShort: String?,
    @SerializedName("Players")
    val players: PlayersX?
)