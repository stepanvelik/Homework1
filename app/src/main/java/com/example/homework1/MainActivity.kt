package com.example.homework1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    QuizApp()
                }
            }
        }
    }
}

val questions = listOf(
    Question(
        "Что такое val в Kotlin?",
        listOf(
            "Изменяемая переменная",
            "Неизменяемая переменная",
            "Функция",
            "Класс"
        ),
        1
    ),
    Question(
        "Как объявить функцию?",
        listOf("fun", "def", "function", "method"),
        0
    ),
    Question(
        "Какой тип используется для значений, которые могут быть null?",
        listOf("String", "String?", "NullableString", "Optional<String>"),
        1
    ),
    Question(
        "Что такое Companion Object?",
        listOf(
            "Объект-компаньон",
            "Статический класс",
            "Вложенный класс",
            "Абстрактный класс"
        ),
        0
    ),
    Question(
        "Какой оператор проверяет равенство по значению?",
        listOf("==", "===", "=", "equals()"),
        0
    )
)




