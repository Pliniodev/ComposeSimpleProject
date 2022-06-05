package com.pliniodev.composesimpleproject.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.Navigator
import com.pliniodev.composesimpleproject.ui.theme.ComposeSimpleProjectTheme
import com.pliniodev.composesimpleproject.view.home.DogsHome

class DogsSingleActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val isDarkTheme = remember { mutableStateOf(false) }

            ComposeSimpleProjectTheme(
                darkTheme = isDarkTheme.value,
                content = {
                    Navigator(DogsHome(isDarkTheme))
                }
            )
        }
    }
}
