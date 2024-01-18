package com.si_assesment_task_compose.utils

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.si_assesment_task_compose.model.MatchDetail.MatchDetailModel
import com.si_assesment_task_compose.utils.Route.Home
import com.si_assesment_task_compose.utils.Route.TeamDetail

interface Destination {
    val route: String
}

object HomePage : Destination {
    override val route: String
        get() = Home

}

object MatchDetailPage : Destination {
    override val route: String
        get() = TeamDetail

    const val teamDetailPageParameters = "team_detail_param"

    val routeWithArgs = "${MatchDetailPage.route}/{$teamDetailPageParameters}"

    val arguments = listOf(
        navArgument(teamDetailPageParameters) { type = teamDetailPageParametersType },

        )
}

val teamDetailPageParametersType = object : NavType<MatchDetailModel>(
    isNullableAllowed = false
) {
    override fun put(bundle: Bundle, key: String, value: MatchDetailModel) {
        bundle.putParcelable(key, value)
    }
    override fun get(bundle: Bundle, key: String): MatchDetailModel? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): MatchDetailModel {
        return Gson().fromJson(value,MatchDetailModel::class.java)
    }

    // Only required when using Navigation 2.4.0-alpha07 and lower
    override val name = "teamDetailPageParameters"
}