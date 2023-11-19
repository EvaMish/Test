package com.example.biatest.ui.theme.bottomNav

import com.example.biatest.R

sealed class BottomItem(val title: String, val iconId: Int, val route: String) {
    object Tasks : BottomItem("Задания", R.drawable.icon_task, "tasks")
    object Charts : BottomItem("Графики", R.drawable.icon_charts, "charts")
    object Chat : BottomItem("Чат", R.drawable.icon_chat, "chat")
    object Profile : BottomItem("Профиль", R.drawable.icon_profile, "profile")
}
