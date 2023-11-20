package com.example.biatest.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.biatest.R
import com.example.biatest.ui.theme.BIAtestTheme
import com.example.biatest.ui.theme.MaskTransformation


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onClick: () -> Unit) {
    var phoneNumber by remember { mutableStateOf("") }
    var isButtonEnabled by remember { mutableStateOf(false) }

    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.biatechnologies),
            contentDescription = "",
            modifier = Modifier
                .size(50.dp)
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            text = stringResource(id = R.string.comf),
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 15.sp
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Text(
            text = stringResource(id = R.string.welcome),
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Normal,
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.padding(7.dp))
        Text(
            text = stringResource(id = R.string.enterPhone),
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Light,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.padding(7.dp))

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { input ->
                val digitsOnly = input.filter { it.isDigit() }
                phoneNumber = digitsOnly
                isButtonEnabled = digitsOnly.isNotEmpty()

                if (digitsOnly.length == 8) {
                    onClick()
                }
            },
            placeholder = {
                Text(
                    text = "99999-999",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            singleLine = true,
            visualTransformation = MaskTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(25.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Black,
                focusedLabelColor = Color.Gray,
                cursorColor = Color.Black
            ),
        )

        Button(
            onClick = {
                // Действия при нажатии кнопки
            },

            enabled = phoneNumber.length==8,
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isButtonEnabled) Color.Black else Color.Gray,
                contentColor =  Color.White ,
                disabledContentColor = Color.Gray
            )
        ) {
            Text(stringResource(id = R.string.next))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    BIAtestTheme() {
        LoginScreen{}
    }
}