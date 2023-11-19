package com.example.biatest.data.models

import java.time.LocalDateTime
import java.time.format.DateTimeFormatterBuilder

data class TasksInfo(
    val dateTime: String,
    val warehouse: String,
    val shift: String,
    val spec: String
)

