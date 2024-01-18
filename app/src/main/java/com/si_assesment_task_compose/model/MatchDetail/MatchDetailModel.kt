package com.si_assesment_task_compose.model.MatchDetail


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MatchDetailModel(
    @SerializedName("Innings")
    val innings: List<Inning>?,
    @SerializedName("Matchdetail")
    val matchdetail: Matchdetail?,
    @SerializedName("Notes")
    val notes: Notes?,
    @SerializedName("Nuggets")
    val nuggets: List<String>?,
    @SerializedName("Teams")
    val team: HashMap<String, TeamInfo?>?
) : Parcelable {

    fun getTeams():List<TeamInfo>{
        val teams = mutableListOf<TeamInfo>()
        team?.forEach {
            it.value?.let { it1 -> teams.add(it1) }
        }

        return teams
    }

    fun getTeam1():TeamInfo = getTeams()[0]
    fun getTeam2():TeamInfo = getTeams()[1]

    fun getOpponents():String{
        return "${getTeam1().nameFull} vs ${getTeam2().nameFull}"
    }

}