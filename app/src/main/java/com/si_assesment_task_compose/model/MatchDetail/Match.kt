package com.si_assesment_task_compose.model.MatchDetail


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Match(
    @SerializedName("Code")
    val code: String?,
    @SerializedName("Date")
    val date: String?,
    @SerializedName("Daynight")
    val daynight: String?,
    @SerializedName("Id")
    val id: String?,
    @SerializedName("League")
    val league: String?,
    @SerializedName("Livecoverage")
    val livecoverage: String?,
    @SerializedName("Number")
    val number: String?,
    @SerializedName("Offset")
    val offset: String?,
    @SerializedName("Time")
    val time: String?,
    @SerializedName("Type")
    val type: String?
) : Parcelable