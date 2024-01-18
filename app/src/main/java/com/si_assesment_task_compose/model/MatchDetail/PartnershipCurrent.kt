package com.si_assesment_task_compose.model.MatchDetail


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PartnershipCurrent(
    @SerializedName("Balls")
    val balls: String?,
    @SerializedName("Batsmen")
    val batsmen: List<BatsmenX>?,
    @SerializedName("Runs")
    val runs: String?
) : Parcelable