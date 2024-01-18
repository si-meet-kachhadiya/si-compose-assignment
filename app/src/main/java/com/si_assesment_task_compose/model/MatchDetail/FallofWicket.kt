package com.si_assesment_task_compose.model.MatchDetail


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FallofWicket(
    @SerializedName("Batsman")
    val batsman: String?,
    @SerializedName("Overs")
    val overs: String?,
    @SerializedName("Score")
    val score: String?
) : Parcelable