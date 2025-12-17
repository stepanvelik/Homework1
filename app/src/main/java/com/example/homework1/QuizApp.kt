package com.example.homework1

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun QuizApp() {
    var showWelcomeScreen by rememberSaveable { mutableStateOf(true) }
    var currentQuestionIndex by rememberSaveable { mutableStateOf(0) }
    var selectedAnswerIndex by rememberSaveable { mutableStateOf<Int?>(null) }
    var score by rememberSaveable { mutableStateOf(0) }
    var isQuizFinished by rememberSaveable { mutableStateOf(false) }

    if (showWelcomeScreen) {
        WelcomeScreen {
            showWelcomeScreen = false
            currentQuestionIndex = 0
            selectedAnswerIndex = null
            score = 0
            isQuizFinished = false
        }
    } else if (currentQuestionIndex < questions.size && !isQuizFinished) {
        QuestionScreen(
            question = questions[currentQuestionIndex],
            questionNumber = currentQuestionIndex + 1,
            totalQuestions = questions.size,
            selectedAnswerIndex = selectedAnswerIndex,
            onAnswerSelected = { index ->
                selectedAnswerIndex = index
            },
            onNext = {
                // Проверяем правильность ответа
                if (selectedAnswerIndex == questions[currentQuestionIndex].correctAnswerIndex) {
                    score++
                }

                // Переходим к следующему вопросу или завершаем
                if (currentQuestionIndex < questions.size - 1) {
                    currentQuestionIndex++
                    selectedAnswerIndex = null
                } else {
                    isQuizFinished = true
                }
            }
        )
    } else {
        ResultScreen(
            score = score,
            totalQuestions = questions.size,
            onRestart = {
                showWelcomeScreen = true
            }
        )
    }
}