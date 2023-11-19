package com.example.biatest.ui.theme.bottomNav

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.biatest.ui.theme.elements.Charts
import com.example.biatest.ui.theme.elements.Chat
import com.example.biatest.ui.theme.elements.Profile
import com.example.biatest.ui.theme.screens.NewTask
import com.example.biatest.ui.theme.screens.TaskList
import com.example.biatest.ui.theme.screens.getTasksList

@Composable
fun NavGraph(navHostController: NavHostController) {
    val taskList = getTasksList()
    NavHost(navController = navHostController, startDestination = "tasks"){
        composable("tasks") {
            TaskList(taskList)
        }
        composable("charts") {
            Charts()
        }
        composable("chat") {
            Chat()
        }
        composable("profile") {
            Profile()
        }
        composable("new_task") {
            AnimatedVisibility(
                visible = true,
                enter = fadeIn() + fadeIn(),
                exit = fadeOut() + fadeOut()
            ) {
                NewTask()
            }
        }
    }
}
