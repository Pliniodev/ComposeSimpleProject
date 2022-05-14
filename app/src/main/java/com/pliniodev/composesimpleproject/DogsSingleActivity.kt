package com.pliniodev.composesimpleproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cafe.adriel.voyager.navigator.Navigator
import com.pliniodev.composesimpleproject.ui.theme.ComposeSimpleProjectTheme
import com.pliniodev.composesimpleproject.view.doglist.DogsListScreen

class DogsSingleActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeSimpleProjectTheme(
                content = {
                    Navigator(DogsListScreen())
                }
            )
        }
    }
}
