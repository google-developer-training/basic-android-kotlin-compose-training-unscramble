package com.example.android.unscramble.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.android.unscramble.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

class GameViewModel : ViewModel() {

    private companion object {
        const val SCORE_POINTS_PER_ROUND = 10
        const val SKIP_WORD_FINE_POINTS = 2
    }

    private var currentScore = 0
    private var tryNumber = 0

    private val usedWords = arrayListOf<String>()
    private val _uiState = MutableStateFlow(
        GameUiState(currentScore, tryNumber, "", false)
    )

    private val random = Random(System.currentTimeMillis())

    private lateinit var currentWord: String

    val uiState: StateFlow<GameUiState>
        get() = _uiState

    var isGameFinished by mutableStateOf(false)
        private set

    var userGuess by mutableStateOf("")
        private set

    init {
        resetGame()

    }

    fun resetGame() {
        isGameFinished = false
        usedWords.clear()
        currentScore = 0
        tryNumber = 0
        userGuess = ""
        _uiState.value = GameUiState(
            score = currentScore,
            tryNumber = tryNumber,
            currentScrambledWord = pickRandomWordAndShuffle(),
            isError = false
        )
    }

    fun onDismissDialogClicked() {
        isGameFinished = false
    }

    fun onUserGuessChanged(guess: String) {
        userGuess = guess
    }

    fun onSubmitButtonClicked() {
        if (tryFinishGame()) return
        when (currentWord == userGuess) {
            true -> {
                increaseScore()
                nextWord()
            }
            false -> {
                _uiState.update {
                    it.copy(
                        isError = true
                    )
                }
            }
        }
    }

    fun onSkipButtonClicked() {
        if (tryFinishGame()) return
        decreaseScore()
        nextWord()
    }

    private fun tryFinishGame(): Boolean {

        isGameFinished = tryNumber == 10

        if (isGameFinished) {

        }

        return isGameFinished
    }

    private fun increaseScore() {
        currentScore += SCORE_POINTS_PER_ROUND
    }

    private fun decreaseScore() {
        currentScore = (currentScore - SKIP_WORD_FINE_POINTS).coerceAtLeast(0)
    }

    private fun nextWord() {
        userGuess = ""
        _uiState.value = GameUiState(
            score = currentScore,
            tryNumber = ++tryNumber,
            currentScrambledWord = pickRandomWordAndShuffle(),
            isError = false
        )
    }

    private fun pickRandomWordAndShuffle(): String{
        currentWord = allWords.random(random)
        return when (usedWords.contains(currentWord)) {
            true -> pickRandomWordAndShuffle()
            false -> shuffle(currentWord)
        }
    }

    private fun shuffle(word: String): String {
        val letters = word.toCharArray()
        letters.shuffle(random)
        while (String(letters) == word) {
            letters.shuffle()
        }
        return String(letters)
    }
}