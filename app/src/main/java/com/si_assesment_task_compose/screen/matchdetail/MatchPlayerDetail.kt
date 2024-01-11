package com.si_assesment_task_compose.screen.matchdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun MatchPlayerDetail(navController: NavHostController) {

    LazyVerticalGrid(
        contentPadding = PaddingValues(top = 15.dp, bottom = 15.dp),
        columns = GridCells.Fixed(2),
        content = {
            items(14) {
                PlayerInfoView()
            }
        })
}

@Composable
fun PlayerInfoView() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = Color.LightGray),
    ) {
        Text(
            text = "W",
            textAlign = TextAlign.End,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 10.dp, top = 10.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "M",
                fontSize = 14.sp,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = Color.Blue)
                    .padding(20.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Player Name",
                fontSize = 16.sp,
            )
        }

    }
}