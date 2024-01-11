package com.si_assesment_task_compose.utils

import com.si_assesment_task_compose.model.MatchDetail.MatchDetailModel
import retrofit2.http.GET

interface MatchService {
    @GET("nzin01312019187360.json")
    suspend fun getMatchDetail(): MatchDetailModel
}