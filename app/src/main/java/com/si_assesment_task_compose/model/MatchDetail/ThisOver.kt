package com.si_assesment_task_compose.model.MatchDetail


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ThisOver(
    @SerializedName("B")
    val b: String?,
    @SerializedName("T")
    val t: String?
) : Parcelable