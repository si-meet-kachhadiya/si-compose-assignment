package com.si_assesment_task_compose.model.MatchDetail


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Batsmen(
    @SerializedName("Balls")
    val balls: String?,
    @SerializedName("Batsman")
    val batsman: String?,
    @SerializedName("Bowler")
    val bowler: String?,
    @SerializedName("Dismissal")
    val dismissal: String?,
    @SerializedName("Dots")
    val dots: String?,
    @SerializedName("Fielder")
    val fielder: String?,
    @SerializedName("Fours")
    val fours: String?,
    @SerializedName("Howout")
    val howout: String?,
    @SerializedName("Isonstrike")
    val isonstrike: Boolean?,
    @SerializedName("Runs")
    val runs: String?,
    @SerializedName("Sixes")
    val sixes: String?,
    @SerializedName("Strikerate")
    val strikerate: String?
) : Parcelable