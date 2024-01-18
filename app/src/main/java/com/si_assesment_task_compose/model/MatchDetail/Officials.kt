package com.si_assesment_task_compose.model.MatchDetail


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Officials(
    @SerializedName("Referee")
    val referee: String?,
    @SerializedName("Umpires")
    val umpires: String?
) : Parcelable