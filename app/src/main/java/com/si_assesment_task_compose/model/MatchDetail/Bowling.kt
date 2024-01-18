package com.si_assesment_task_compose.model.MatchDetail


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Bowling(
    @SerializedName("Average")
    val average: String?,
    @SerializedName("Economyrate")
    val economyrate: String?,
    @SerializedName("Style")
    val style: String?,
    @SerializedName("Wickets")
    val wickets: String?
) : Parcelable