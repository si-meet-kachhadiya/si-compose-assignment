package com.si_assesment_task_compose.model.MatchDetail


import com.google.gson.annotations.SerializedName

data class PlayerInfo(
    @SerializedName("Batting")
    val batting: Batting?,
    @SerializedName("Bowling")
    val bowling: Bowling?,
    @SerializedName("Name_Full")
    val nameFull: String?,
    @SerializedName("Position")
    val position: String?,
    @SerializedName("Iscaptain")
val iscaptain: Boolean?,
)