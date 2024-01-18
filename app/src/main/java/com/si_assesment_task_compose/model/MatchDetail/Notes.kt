package com.si_assesment_task_compose.model.MatchDetail


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Notes(
    @SerializedName("1")
    val x1: List<String?>?,
    @SerializedName("2")
    val x2: List<String?>?
) : Parcelable