package com.si_assesment_task_compose.screen.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.rememberNavController
import com.si_assesment_task_compose.R
import com.si_assesment_task_compose.ui.theme.SiAssesmentTaskComposeTheme
import com.si_assesment_task_compose.utils.NavHostContainer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            SiAssesmentTaskComposeTheme {
                BindHome()
//                TeamDisplay()
//                MatchPlayerDetail()
            }
        }
    }

    @Composable
    fun BindHome() {

        val navController = rememberNavController()

        Scaffold(backgroundColor = colorResource(id = R.color.white),
            content = { padding ->
                // Nav host: where screens are placed
                NavHostContainer(navController = navController, padding = padding)
            })
    }
}