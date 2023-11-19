package com.example.biatest.ui.theme.elements

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.biatest.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopNavigation(navController: NavController) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    if (currentRoute == "tasks") {
        TopAppBar(
            title = {
                Text(
                    text = "Задания",
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 25.sp
                )
            },
            actions = {
                IconButton(
                    onClick = {
                        navController.navigate("new_task")
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_add_circle_outline_24),
                        contentDescription = "",
                    )
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.White
            )
        )
    }
}
