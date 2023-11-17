package com.example.biatest.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.biatest.R
import com.example.biatest.ui.theme.BIAtestTheme
import com.example.biatest.ui.theme.MaskTransformation


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenPass(
    onClick: () -> Unit,
    navController: NavHostController,
    onIconButtonClick: () -> Unit,
) {

    var isButtonEnabled by remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp),
        horizontalArrangement = Arrangement.Start, // Align the content of the row to the start (left)
        verticalAlignment = Alignment.CenterVertically // Align the content of the row to the top
    ) {
        Image(
            painter = painterResource(id = R.drawable.biatechnologies),
            contentDescription = "",
            modifier = Modifier
                .size(50.dp)
        )
        Spacer(modifier = Modifier.width(2.dp)) // Add space between the image and the text
        Text(
            text = "УдобнаяСмена",
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 15.sp
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { onIconButtonClick() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Информация о приложении")
            }
            Text(
                text = stringResource(id = R.string.enterPass),
                color = Color.Black,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                fontSize = 25.sp
            )
        }
        Spacer(modifier = Modifier.padding(7.dp))
        Text(
            text = stringResource(id = R.string.passWeb),
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Light,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.padding(7.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { input ->
                if (input.length <= 6) {
                    password = input
                }

                if (input.length == 6) {
                    onClick()
                }
            },
            placeholder = {
                Text(
                    text = "_  _  _  _  _  _",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(25.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Black,
                focusedLabelColor = Color.Gray,
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password
            ),
            maxLines = 1,
        )

        Button(
            onClick = {
                onClick()
                navController.navigate("your_destination")
            },
            enabled = password.length == 6,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isButtonEnabled) Color.Black else Color.Gray,
                contentColor = Color.White,
                disabledContentColor = Color.Gray
            )
        ) {
            Text("Продолжить")
        }


    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreenPass() {
    BIAtestTheme() {
        LoginScreenPass(
            navController = rememberNavController(),
            onIconButtonClick = {},
            onClick = {}
        )
    }
}