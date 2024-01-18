package com.si_assesment_task_compose.model.MatchDetail


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Bowler(
    @SerializedName("Bowler")
    val bowler: String?,
    @SerializedName("Dots")
    val dots: String?,
    @SerializedName("Economyrate")
    val economyrate: String?,
    @SerializedName("Isbowlingnow")
    val isbowlingnow: Boolean?,
    @SerializedName("Isbowlingtandem")
    val isbowlingtandem: Boolean?,
    @SerializedName("Maidens")
    val maidens: String?,
    @SerializedName("Noballs")
    val noballs: String?,
    @SerializedName("Overs")
    val overs: String?,
    @SerializedName("Runs")
    val runs: String?,
    @SerializedName("ThisOver")
    val thisOver: List<ThisOver?>?,
    @SerializedName("Wickets")
    val wickets: String?,
    @SerializedName("Wides")
    val wides: String?
) : Parcelable