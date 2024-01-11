package com.si_assesment_task_compose.utils

import com.si_assesment_task_compose.model.MatchDetail.MatchDetailModel

class MatchRepository {
    private val matchService = RetrofitInstance.matchServices

    suspend fun getMatches(): MatchDetailModel {
        return matchService.getMatchDetail()
    }
}