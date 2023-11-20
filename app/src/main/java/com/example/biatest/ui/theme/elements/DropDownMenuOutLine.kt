package com.example.biatest.ui.theme.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biatest.ui.theme.BIAtestTheme

@Composable
fun DropdownTextField(placeholder: String) {
    var isDropdownVisible by remember { mutableStateOf(false) }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable {
                    isDropdownVisible = !isDropdownVisible
                },


            ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                readOnly = true,
                placeholder = {
                    Text(
                        text = placeholder,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                },
                modifier = Modifier
                    .border(
                        1.dp,
                        Color.Gray,
                        shape = RoundedCornerShape(25.dp)
                    )
                    .fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        tint = Color.DarkGray,
                        modifier = Modifier
                            .clickable {
                                isDropdownVisible = !isDropdownVisible
                            }
                            .padding(16.dp),

                        )

                },
                shape = RoundedCornerShape(25.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor =  Color.Gray)

                )
        }

        if (isDropdownVisible) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Text(
                    text = "Тип 1",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
                Text(
                    text = "Тип 2",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
                Text(
                    text = "Тип 3",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
            }
        }
    }
}


@Composable
fun DropdownTextFieldExample(placeholder: String) {
    BIAtestTheme {
        DropdownTextField(placeholder)
    }
}