package com.example.biatest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.biatest.ui.theme.BIAtestTheme
import com.example.biatest.ui.theme.screens.LoginScreen
import com.example.biatest.ui.theme.screens.LoginScreenPass
import com.example.biatest.ui.theme.screens.MainScreen
import com.example.biatest.ui.theme.screens.SplashScreen

class MainActivity : ComponentActivity() {
    private val navController by lazy {
        rememberNavController()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
           // val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "auth"
            ) {

                composable("auth") {
                    AnimatedVisibility(
                        visible = true,
                        enter = fadeIn() + fadeIn(),
                        exit = fadeOut() + fadeOut()
                    ) {
                        LoginScreen {
                            navController.navigate("screenAuthPass")
                        }

                    }
                }

                composable("screenAuthPass") {
                    AnimatedVisibility(
                        visible = true,
                        enter = fadeIn() + fadeIn(),
                        exit = fadeOut() + fadeOut()
                    ) {
                        LoginScreenPass {
                            navController.navigate("screenMain") {
//                                popUpTo("screenAuthPass") {////+++++++++
//                                    inclusive = true
//                                }
                            }
                        }
                    }
                }

                composable("screenMain") {
                    AnimatedVisibility(
                        visible = true,
                        enter = fadeIn() + fadeIn(),
                        exit = fadeOut() + fadeOut()
                    ) {
                        MainScreen ()
//                            navController.navigate("screenMain") {
////                                popUpTo("screenAuthPass") {////+++++++++
////                                    inclusive = true
////                                }
//                            }

                    }
                }




            }
        }
    }



}
