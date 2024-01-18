package com.si_assesment_task_compose.model.MatchDetail


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TeamInfo(
    @SerializedName("Name_Full")
    val nameFull: String?,
    @SerializedName("Name_Short")
    val nameShort: String?,
    @SerializedName("Players")
    val player: HashMap<String, PlayerInfo?>?,
    ) : Parcelable