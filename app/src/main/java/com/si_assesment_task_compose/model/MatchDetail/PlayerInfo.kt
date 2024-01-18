package com.si_assesment_task_compose.model.MatchDetail


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
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
    @SerializedName("Iskeeper")
    val Iskeeper: Boolean?
) : Parcelable