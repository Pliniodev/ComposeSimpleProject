package com.pliniodev.composesimpleproject.view.component.default

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun DefaultTopAppBar(titleScreen: String) {
    val materialBlue700 = Color(0xFF1976D2)
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = { Text(titleScreen) },
        backgroundColor = materialBlue700
    )
}
