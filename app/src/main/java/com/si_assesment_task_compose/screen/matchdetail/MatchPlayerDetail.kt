package com.si_assesment_task_compose.screen.matchdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.RadioButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.RadioButton
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.si_assesment_task_compose.model.MatchDetail.MatchDetailModel
import com.si_assesment_task_compose.model.MatchDetail.PlayerInfo
import com.si_assesment_task_compose.model.MatchDetail.TeamInfo


@Composable
fun MatchPlayerDetail(navController: NavHostController, matchDetailArgs: MatchDetailModel) {


    val players = remember {
        mutableStateListOf<PlayerInfo>()
    }

    var selectedIndex by remember {
        mutableStateOf<Int>(0)
    }

    when (selectedIndex) {
        0 -> {
            players.clear()
            matchDetailArgs.getTeams().forEach { team ->
                team.player?.values?.forEach {
                    if (it != null) {
                        players.add(it)
                    }
                }
            }
        }
        1 -> {
            players.clear()
            matchDetailArgs.getTeams()[0].player?.values?.forEach {
                if (it != null) {
                    players.add(it)
                }
            }
        }
        2 -> {
            players.clear()
            matchDetailArgs.getTeams()[1].player?.values?.forEach {
                if (it != null) {
                    players.add(it)
                }
            }
        }
        else -> {
            players.clear()
            matchDetailArgs.getTeams().forEach { team ->
                team.player?.values?.forEach {
                    if (it != null) {
                        players.add(it)
                    }
                }
            }
        }
    }

    Column {
        TeamSelectionOptions { index ->
            selectedIndex = index
        }

        LazyVerticalGrid(
            contentPadding = PaddingValues(top = 15.dp, bottom = 15.dp),
            columns = GridCells.Fixed(2),
            content = {
                items(players) { playerInfo ->
                    PlayerInfoView(playerInfo)
                }
            })
    }

}

@Composable
fun PlayerInfoView(playerInfo: PlayerInfo) {

    var isVisiblePlayerRole by remember { mutableStateOf(false) }
    var isDialogShow by remember { mutableStateOf(false) }
    isVisiblePlayerRole = playerInfo.Iskeeper == true || playerInfo.iscaptain == true

    if (isDialogShow) {
        PlayerStyleDialog(playerInfo) {
            isDialogShow = false
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = Color.LightGray)
            .clickable { isDialogShow = !isDialogShow },
    ) {
        if (isVisiblePlayerRole) {
            Text(
                text = if (playerInfo.Iskeeper == true) {
                    "W"
                } else if (playerInfo.iscaptain == true) {
                    "C"
                } else if (playerInfo.iscaptain == true && playerInfo.Iskeeper == true) {
                    "C & WK"
                } else {
                    ""
                },
                textAlign = TextAlign.End,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(end = 10.dp, top = 10.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = playerInfo.nameFull?.first()?.uppercase() ?: "",
                fontSize = 14.sp,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = Color.Blue)
                    .padding(20.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = playerInfo.nameFull ?: "",
                fontSize = 16.sp,
            )
        }

    }
}

@Composable
fun PlayerStyleDialog(playerInfo: PlayerInfo, onDismiss: () -> Unit) {
    Dialog(onDismissRequest = {
        onDismiss.invoke()
    }) {
        Surface(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
                Text(
                    text = playerInfo.nameFull ?: "", textAlign = TextAlign.Start,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                )

                Text(
                    text = "Batting Style", textAlign = TextAlign.Start,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                )

                Divider(
                    thickness = 2.dp,
                    color = Color.LightGray,
                    modifier = Modifier.padding(vertical = 10.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Style", textAlign = TextAlign.Start,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = playerInfo.batting?.style ?: "", textAlign = TextAlign.Start,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Average", textAlign = TextAlign.Start,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = playerInfo.batting?.average ?: "", textAlign = TextAlign.Start,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Strikerate", textAlign = TextAlign.Start,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = playerInfo.batting?.strikerate ?: "", textAlign = TextAlign.Start,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Runs", textAlign = TextAlign.Start,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = playerInfo.batting?.runs ?: "", textAlign = TextAlign.Start,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Text(
                    text = "Bowling Stats", textAlign = TextAlign.Start,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                )

                Divider(
                    thickness = 2.dp,
                    color = Color.LightGray,
                    modifier = Modifier.padding(vertical = 10.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Style", textAlign = TextAlign.Start,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = playerInfo.bowling?.style ?: "", textAlign = TextAlign.Start,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Average", textAlign = TextAlign.Start,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = playerInfo.bowling?.average ?: "", textAlign = TextAlign.Start,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Economy Rate", textAlign = TextAlign.Start,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = playerInfo.bowling?.economyrate ?: "", textAlign = TextAlign.Start,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Wickets", textAlign = TextAlign.Start,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = playerInfo.bowling?.wickets ?: "", textAlign = TextAlign.Start,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

            }
        }
    }
}

@Composable
fun TeamSelectionOptions(selectedIndex: (Int) -> Unit) {
    val radioOptions = listOf("All", "IND", "NZ")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {
            radioOptions.forEachIndexed { index, text ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (text == selectedOption),
                            onClick = {
                                onOptionSelected(text)
                                selectedIndex.invoke(index)
                            }
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = CenterVertically
                ) {

                    RadioButton(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)

                        }
                    )

                    Text(
                        text = text,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ItemPlayerStyle() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "styles", textAlign = TextAlign.Start,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light
            )
            Text(
                text = "styles values", textAlign = TextAlign.Start,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}