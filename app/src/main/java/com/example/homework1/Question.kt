package com.example.homework1

data class Question(
    val title: String,
    val answers: List<String>,
    val correctAnswerIndex: Int
)