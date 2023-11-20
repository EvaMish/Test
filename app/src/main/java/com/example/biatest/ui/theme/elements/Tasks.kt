package com.example.biatest.ui.theme.elements

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biatest.R
import com.example.biatest.data.models.TasksInfo
import com.example.biatest.ui.theme.BIAtestTheme
import androidx.compose.runtime.*

@Composable
fun Tasks(taskInfo: TasksInfo) {
    var isPopupVisible by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.build),
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
            )
            Text(
                text = taskInfo.dateTime,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Light,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Слово "Склад" слева
                Text(
                    text = "Склад",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = Color.Gray // Цвет для слова "Склад"
                )

                // Значение taskInfo.warehouse справа
                Text(
                    text = taskInfo.warehouse,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.Black // Цвет для значения warehouse
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Слово "Склад" слева
                Text(
                    text = "Смена",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = Color.Gray // Цвет для слова "Склад"
                )

                // Значение taskInfo.warehouse справа
                Text(
                    text = taskInfo.shift,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.Black // Цвет для значения warehouse
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Слово "Склад" слева
                Text(
                    text = "Специальность",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = Color.Gray // Цвет для слова "Склад"
                )

                // Значение taskInfo.warehouse справа
                Text(
                    text = taskInfo.spec,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color.Black // Цвет для значения warehouse
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            if (isPopupVisible) {
//                AnimatedVisibility(
//                    visible = isPopupVisible,
//                    enter = fadeIn(
//                        animationSpec = tween(
//                            durationMillis = 300,
//                            easing = LinearEasing
//                        )
//                    ),
//                    exit = fadeOut(animationSpec = tween(durationMillis = 300)),
//                ) {
                    PopupCard()
//                }
            } else {
                Button(
                    onClick = { isPopupVisible = true },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White,
                    )
                ) {
                    Text(
                        stringResource(id = R.string.selection),
                        fontSize = 15.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                    )
                }

                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.LightGray,
                        contentColor = Color.Black,
                    )
                ) {
                    Text(
                        stringResource(id = R.string.edit),
                        fontSize = 15.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


@Composable
fun PopupCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
            contentColor = Color.LightGray
        )
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .background(Color.LightGray)
        ) {

            Text(
                text = stringResource(id = R.string.empl),
                color = colorResource(id = R.color.green),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp

            )
            Text(
                text = "Идет выполнение задания", color = Color.Black,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Light,
                fontSize = 15.sp
            )

        }
    }
}

@Preview
@Composable
fun prewTasks() {
    BIAtestTheme {
        Tasks(
            TasksInfo(
                "11.08.2023·(21:00-9:00)",
                "Москва-Север-1",
                "Ночная смена",
                "Сборщик"
            ),
        )
    }
}


@Composable
fun Charts() {
    Text(text = "charts")
}

@Composable
fun Chat() {
    Text(text = "chat")
}

@Composable
fun Profile() {
    Text(text = "Profile")
}