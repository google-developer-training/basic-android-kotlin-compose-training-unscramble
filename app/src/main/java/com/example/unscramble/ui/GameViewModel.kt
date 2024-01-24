package com.example.unscramble.ui
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.unscramble.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class GameViewModel: ViewModel()  {
    private lateinit var currentWord: String
    var userGuess by mutableStateOf("")
        private set
     val _uiState = MutableStateFlow(GameUiState()) // tell the updates
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    private var _count :Int= 0
    val count: Int get() =_count
    private var usedWords = mutableSetOf<String>()


    private fun pickRandomWordAndShuffle(): String {
        // Continue picking up a new random word until you get one that hasn't been used before
        currentWord = allWords.random()
        if (usedWords.contains(currentWord)) {
            return pickRandomWordAndShuffle()
        } else {
            usedWords.add(currentWord)
            return shuffleCurrentWord(currentWord)
        }
    }
    fun updateUserGuess(guessedWord: String){
        userGuess = guessedWord
    }
    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()

        tempWord.shuffle()
        while (String(tempWord).equals(word)) {
            tempWord.shuffle()
        }
        return String(tempWord)
    }
    fun resetGame() {
        usedWords.clear()
        _uiState.value = GameUiState(pickRandomWordAndShuffle())
    }
    fun ui(): MutableStateFlow<GameUiState> {
        return _uiState
    }
    init {
        resetGame()
    }
}
