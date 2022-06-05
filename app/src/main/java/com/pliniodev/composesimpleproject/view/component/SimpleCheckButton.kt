package com.pliniodev.composesimpleproject.view.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimpleCheckButton(isCheckedState: MutableState<Boolean>, title: String) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Checkbox(
            modifier = Modifier.align(Alignment.CenterVertically),
            checked = isCheckedState.value,
            onCheckedChange = { isCheckedState.value = it }
        )
        Text(modifier = Modifier.align(Alignment.CenterVertically), text = title)
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleCheckButtonTest() {
    val clicked = remember { mutableStateOf(true) }
    SimpleCheckButton(isCheckedState = clicked, title = "Your title")
}
