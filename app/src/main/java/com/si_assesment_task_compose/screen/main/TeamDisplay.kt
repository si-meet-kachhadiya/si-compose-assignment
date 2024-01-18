package com.si_assesment_task_compose.screen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.si_assesment_task_compose.model.MatchDetail.MatchDetailModel
import com.si_assesment_task_compose.utils.Route.TeamDetail

@Composable
fun TeamDisplay(
    navController: NavHostController,
    onDetailClick: (pointsTableList: MatchDetailModel?) -> Unit
) {

    val viewModel: MainViewModel = viewModel()

    LaunchedEffect(key1 = Unit) {
        viewModel.fetchMatches()
    }

    val pointsTableList by viewModel.matches.observeAsState(initial = null)
    MatchCard(pointsTableList) {
        onDetailClick.invoke(it)
    }
}

@Composable
fun MatchCard(
    pointsTableList: MatchDetailModel?,
    onDetailClick: (pointsTableList: MatchDetailModel?) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 15.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = pointsTableList?.getOpponents().orEmpty(),
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = "${pointsTableList?.matchdetail?.match?.date} ${pointsTableList?.matchdetail?.match?.time}",
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
            )

            Text(
                text = pointsTableList?.matchdetail?.venue?.name ?: "",
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
            )

            Button(onClick = { onDetailClick.invoke(pointsTableList) }) {
                Text(text = "Match Detail")
            }
        }
    }
}