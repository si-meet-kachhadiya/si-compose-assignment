package com.si_assesment_task_compose.model.MatchDetail


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Venue(
    @SerializedName("Id")
    val id: String?,
    @SerializedName("Name")
    val name: String?
) : Parcelable