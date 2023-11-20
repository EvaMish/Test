package com.example.biatest.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.biatest.data.models.TasksInfo
import com.example.biatest.ui.theme.elements.NewTaskExecutor
import com.example.biatest.ui.theme.elements.NewTaskSelection
import com.example.biatest.ui.theme.elements.Tasks

@Composable
fun NewTaskLazyColumn() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        contentPadding = PaddingValues(horizontal =15.dp, vertical = 20.dp)
    ) {
        item {
            NewTaskSelection()
        }

        item {
            NewTaskExecutor()
        }
    }

}

@Preview
@Composable
fun previewNewTask() {
    NewTaskLazyColumn()
}