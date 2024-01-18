package com.si_assesment_task_compose.model.MatchDetail


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Series(
    @SerializedName("Id")
    val id: String?,
    @SerializedName("Name")
    val name: String?,
    @SerializedName("Status")
    val status: String?,
    @SerializedName("Tour")
    val tour: String?,
    @SerializedName("Tour_Name")
    val tourName: String?
) : Parcelable