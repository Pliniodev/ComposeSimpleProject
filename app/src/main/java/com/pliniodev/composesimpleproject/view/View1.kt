package com.pliniodev.composesimpleproject.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pliniodev.composesimpleproject.component.BoxedText

@Composable
fun View1(action: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BoxedText(text = "This is view1")
        NavButton(action, "Go to view2")
    }
}

@Composable
fun NavButton(action: () -> Unit = {}, text: String){
    Button(
        onClick = action,
        // Uses ButtonDefaults.ContentPadding by default
        contentPadding = PaddingValues(
            start = 20.dp,
            top = 12.dp,
            end = 20.dp,
            bottom = 12.dp
        )
    ) {
        // Inner content including an icon and a text label
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text)
        Icon(
            Icons.Filled.ArrowForward,
            contentDescription = "Favorite",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewView1(){
    View1 {  }
}