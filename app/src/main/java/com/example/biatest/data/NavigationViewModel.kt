package com.example.biatest.data

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.biatest.ui.theme.bottomNav.BottomItem

class NavigationViewModel : ViewModel() {
    lateinit var navController: NavHostController
}
