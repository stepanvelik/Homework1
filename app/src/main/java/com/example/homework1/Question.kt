package com.example.test

data class Question(
    val title: String,
    val answers: List<String>,
    val correctAnswerIndex: Int
)