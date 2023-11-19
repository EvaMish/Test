package com.example.biatest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.biatest.data.NavigationViewModel
import com.example.biatest.ui.theme.screens.LoginScreen
import com.example.biatest.ui.theme.screens.LoginScreenPass
import com.example.biatest.ui.theme.screens.MainScreen
import com.example.biatest.ui.theme.screens.NewTask
import com.example.biatest.ui.theme.screens.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel = ViewModelProvider(this).get(NavigationViewModel::class.java)
            viewModel.navController = rememberNavController()
            AnimatedVisibility(
                visible = true,
                enter = fadeIn() + fadeIn(),
                exit = fadeOut() + fadeOut()
            ) {
                NavHost(
                    navController = viewModel.navController,
                    startDestination = "auth"
                ) {
                    composable("auth") {
                        LoginScreen {
                            viewModel.navController.navigate("screenAuthPass")
                        }
                    }
                    composable("screenAuthPass") {
                        LoginScreenPass(
                            navController = viewModel.navController,
                            onIconButtonClick = {
                                viewModel.navController.navigate("auth")
                            },
                            onClick = {
                                viewModel.navController.navigate("screenMain")
                            }
                        )
                    }
                    composable("screenMain") {
                        MainScreen()
                    }

                }


            }
        }
    }
}
