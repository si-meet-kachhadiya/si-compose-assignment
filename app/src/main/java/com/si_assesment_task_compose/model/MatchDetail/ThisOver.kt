package com.si_assesment_task_compose.model.MatchDetail


import com.google.gson.annotations.SerializedName

data class ThisOver(
    @SerializedName("B")
    val b: String?,
    @SerializedName("T")
    val t: String?
)