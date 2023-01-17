package com.example.android.unscramble.ui

data class GameUiState(

    val score: Int,
    val tryNumber: Int,
    val currentScrambledWord: String,
    val isError: Boolean
)