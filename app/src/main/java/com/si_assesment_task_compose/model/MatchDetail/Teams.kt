package com.si_assesment_task_compose.model.MatchDetail


data class Teams(
    val team: HashMap<String, TeamInfo?>?,
){

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
