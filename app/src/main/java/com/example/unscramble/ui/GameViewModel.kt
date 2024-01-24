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
import kotlinx.coroutines.flow.update


class GameViewModel: ViewModel(){
    private lateinit var currentWord: String
    var userGuess by mutableStateOf("")
        private set
    private val _uiState = MutableStateFlow(GameUiState())

    // tell the updates
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    private var _count :Int= 0
    val count: Int get() =_count
    private var usedWords = mutableSetOf<String>()


    private fun pickRandomWordAndShuffle(): String {
        // Continue picking up a new random word until you get one that hasn't been used before
        currentWord = allWords.random()
        return if (usedWords.contains(currentWord)) {
            pickRandomWordAndShuffle()
        } else {
            usedWords.add(currentWord)
            shuffleCurrentWord(currentWord)
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
    fun checkUserGuess(){
        if (userGuess.equals(currentWord, ignoreCase = true)) {

            userGuess="";
            var check: Int=_uiState.value.currentWordCount
            if(_uiState.value.currentWordCount!=3)check++
            _uiState.update { currentState ->
                currentState.copy(pickRandomWordAndShuffle(), isGuessedWordWrong = false, score= currentState.score+20 , currentWordCount = check )
            }

        } else {
            Log.d("checking", currentWord)
            userGuess=""
            _uiState.update { currentState ->
                currentState.copy(isGuessedWordWrong = true)
            }
        }
    }
    fun resetGame() {
        usedWords.clear()
        _uiState.value = GameUiState(pickRandomWordAndShuffle(), isGuessedWordWrong = false, score = 0, currentWordCount = 1)
    }

    init {
        resetGame()
    }

}
