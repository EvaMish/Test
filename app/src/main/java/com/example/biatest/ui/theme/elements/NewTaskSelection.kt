package com.example.biatest.ui.theme.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biatest.R
import com.example.biatest.ui.theme.BIAtestTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTaskSelection() {
    var typeTask by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }
    var textCount by remember { mutableStateOf("") }

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
                .padding(25.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                text = stringResource(id = R.string.info),
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(start = 12.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            DropdownTextFieldExample(stringResource(id = R.string.typeTask))

            OutlinedTextField(
                value = text,
                placeholder = {
                    Text(
                        stringResource(id = R.string.additional),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                },
                onValueChange = { newText ->
                    text = newText
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 100.dp)
                    .padding(end = 16.dp, start = 14.dp)
                    .border(
                        1.dp,
                        Color.Gray,
                        shape = RoundedCornerShape(25.dp)
                    ),
                textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                shape = RoundedCornerShape(25.dp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Gray,
                    cursorColor = Color.Black
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = textCount,
                onValueChange = { newText ->
                    if (newText.all { it.isDigit() }) { // Убедимся, что вводятся только цифры
                        textCount = newText
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp, start = 14.dp)
                    .border(
                        1.dp,
                        Color.Gray,
                        shape = RoundedCornerShape(25.dp)
                    ),
                textStyle = TextStyle.Default.copy(fontSize = 16.sp),
                shape = RoundedCornerShape(25.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done,
                ),
                placeholder = {
                    Text(
                        stringResource(id = R.string.count), fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Gray,
                    cursorColor = Color.Black
                )
            )

            DropdownTextFieldExample(placeholder = stringResource(id = R.string.spec))
        }


    }

    Spacer(modifier = Modifier.height(20.dp))

}


@Preview
@Composable
fun prewTasks1122() {
    BIAtestTheme {
        NewTaskSelection()
    }
}
