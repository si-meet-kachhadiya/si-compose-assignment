package com.si_assesment_task_compose.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.si_assesment_task_compose.screen.main.TeamDisplay
import com.si_assesment_task_compose.screen.matchdetail.MatchPlayerDetail
import com.si_assesment_task_compose.utils.Route.Home
import com.si_assesment_task_compose.utils.Route.TeamDetail

@Composable
fun NavHostContainer(
    navController: NavHostController, padding: PaddingValues
) {

    val currentPadding = padding.calculateBottomPadding().value.toInt()

    val paddingBottom = if (currentPadding > 0) {
        currentPadding - 10
    } else {
        0
    }

    NavHost(navController = navController,
        // set the start destination as home
        startDestination = Home,

        // Set the padding provided by scaffold
        modifier = Modifier.padding(bottom = paddingBottom.dp),

        builder = {

            // route : Home
            composable(Home) {
                TeamDisplay(navController)
            }

            // route : Player detail
            composable(TeamDetail) {
                MatchPlayerDetail(navController)
            }

        })

}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }