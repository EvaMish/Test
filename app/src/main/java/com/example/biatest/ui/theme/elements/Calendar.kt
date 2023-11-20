package com.example.biatest.ui.theme.elements

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biatest.R
import java.util.Date

@Composable
fun Calendar() {

    var datePicked by remember { mutableStateOf("1") }

    val context = LocalContext.current
    val year: Int
    val month: Int
    val day: Int

    val calendar = java.util.Calendar.getInstance()
    year = calendar.get(java.util.Calendar.YEAR)
    month = calendar.get(java.util.Calendar.MONTH)
    day = calendar.get(java.util.Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val datePickerDialog = DatePickerDialog(
        context,
        R.style.CustomDatePickerDialog,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            datePicked = "$dayOfMonth/$month/$year"
        }, year, month, day
    )

    OutlinedTextField(
        value = "",
        onValueChange = {},
        readOnly = true,
        placeholder = {
            Text(
                text = "Дата исполнения",
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
                imageVector = Icons.Default.DateRange,
                contentDescription = null,
                tint = Color.DarkGray,
                modifier = Modifier
                    .clickable {
                        datePickerDialog.show()
                    }
                    .padding(16.dp),
            )
        },
        shape = RoundedCornerShape(25.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Gray
        )

    )


}

