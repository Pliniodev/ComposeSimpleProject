package com.pliniodev.composesimpleproject.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pliniodev.composesimpleproject.component.BoxedText

@Composable
fun Home(action: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BoxedText(text = "This is Home")
        NavButton(action, "Go to view1")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHome(action: () -> Unit = {}){
    Home(action)
}