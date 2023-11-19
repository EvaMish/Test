package com.example.biatest.ui.theme.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.biatest.ui.theme.bottomNav.MyBottomNavigation
import com.example.biatest.ui.theme.bottomNav.NavGraph
import com.example.biatest.ui.theme.elements.MyTopNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navControllerBottom = rememberNavController()
    Scaffold(
        topBar = {
            MyTopNavigation(navController = navControllerBottom)
        },
        bottomBar = {
            MyBottomNavigation(navController = navControllerBottom)
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            NavGraph(navHostController = navControllerBottom)
        }
    }
}
