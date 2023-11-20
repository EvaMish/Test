package com.example.biatest.ui.theme.elements

import android.app.DatePickerDialog
import android.widget.DatePicker
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biatest.R
import com.example.biatest.ui.theme.BIAtestTheme
import java.util.Calendar
import java.util.Date

@Composable
fun NewTaskExecutor() {

    var typeTask by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }
    var textCount by remember { mutableStateOf("") }


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.White
        )

    ) {

        Column(
            modifier = Modifier
                .padding(20.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom
        ) {

            Text(
                text = stringResource(id = R.string.executor),
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(start = 12.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.padding(14.dp)) {
                Calendar()
            }
            Row(modifier = Modifier.padding(0.dp)) {
                DropdownTextFieldExample(placeholder = "Склад")
            }
            Row(modifier = Modifier.padding(5.dp)) {
                Spacer(modifier = Modifier.height(20.dp))
                RadioButtonExample()
            }

        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun RadioButtonExample() {
    var selectedOption by remember { mutableStateOf(Option.OPTION1) }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start, // Align the content of the row to the start (left)
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedOption == Option.OPTION1,
                onClick = { selectedOption = Option.OPTION1 },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Red,
                    unselectedColor = Color.Gray
                ),
            )
            Text(
                text = "Дневная смена (9:00-21:00)", color = Color.Black,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Light,
            )
        }

        Spacer(modifier = Modifier.width(5.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start, // Align the content of the row to the start (left)
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedOption == Option.OPTION2,
                onClick = { selectedOption = Option.OPTION2 },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Red,
                    unselectedColor = Color.Gray
                ),
            )

            Text(
                text = "Ночная смена (21:00-9:00)", color = Color.Black,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Light,
            )
        }

    }

}

enum class Option {
    OPTION1,
    OPTION2
}


@Preview
@Composable
fun prewTasks1122123() {
    BIAtestTheme {
        NewTaskExecutor()
    }
}
