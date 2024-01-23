/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.unscramble

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.unscramble.ui.GameScreen
import com.example.unscramble.ui.GameViewModel
import com.example.unscramble.ui.theme.UnscrambleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Create function is called ")
        GameViewModel()
        setContent {
            UnscrambleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GameScreen()
                }
            }
        }
    }

    override fun onPause() {
        println("Pause function is called ")
        super.onPause()
    }override fun onResume() {
        println("Resume function is called ")
        super.onResume()
    }
    override fun onStart() {
        println("Start function is called ")
        super.onStart()
    }

    override fun on

    override fun onStop() {
        super.onStop()
        println("Stop function is called ")
    }

    override fun onDestroy(){
        println("Destroy function is called ")
        super.onDestroy()

    }


}
