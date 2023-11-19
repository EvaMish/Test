package com.example.biatest.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.biatest.R
import com.example.biatest.data.models.TasksInfo
import com.example.biatest.ui.theme.BIAtestTheme
import com.example.biatest.ui.theme.elements.Tasks

private val carList = getTasksList()

@Composable
fun TaskList(task: List<TasksInfo>) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 20.dp)
    ) {
        items(task) { task ->
            Tasks(task)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }

}

fun getTasksList(): List<TasksInfo> {
    return listOf(
        TasksInfo(
            "11.08.2023·(21:00-9:00)",
            "Москва-Север-1",
            "Ночная смена",
            "Сборщик 1"
        ),
        TasksInfo(
            "10.08.2023·(9:00-21:00)",
            "Москва-Север-2",
            "Дневная смена",
            "Сборщик 2"
        ),
        TasksInfo(
            "12.08.2023·(21:00-9:00)",
            "Москва-Север-3",
            "Ночная смена",
            "Сборщик 3"
        ),


        // Добавьте другие машины по мере необходимости
    )
}


@Preview
@Composable
fun prewTasks2() {
    BIAtestTheme {
        TaskList(
            task =
            listOf(
                TasksInfo(
                    "11.08.2023·(21:00-9:00)",
                    "Москва-Север-1",
                    "Ночная смена",
                    "Сборщик 1"
                ),
                TasksInfo(
                    "10.08.2023·(9:00-21:00)",
                    "Москва-Север-2",
                    "Дневная смена",
                    "Сборщик 2"
                ),
                TasksInfo(
                    "12.08.2023·(21:00-9:00)",
                    "Москва-Север-3",
                    "Ночная смена",
                    "Сборщик 3"
                ),


                // Добавьте другие машины по мере необходимости
            )
        )
    }
}
