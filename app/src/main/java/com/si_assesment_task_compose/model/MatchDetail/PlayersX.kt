package com.si_assesment_task_compose.model.MatchDetail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlayersX(
    val player: HashMap<String, PlayerInfo?>?,
) : Parcelable