package com.pliniodev.composesimpleproject.view.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.pliniodev.composesimpleproject.ui.theme.ComposeSimpleProjectTheme
import com.pliniodev.composesimpleproject.view.component.FullDogImage
import com.pliniodev.composesimpleproject.view.component.default.DefaultTopAppBar
import com.pliniodev.composesimpleproject.view.doglist.DogsListScreen

class DogsHome : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val isDarkTheme = remember { mutableStateOf(false) }

        ComposeSimpleProjectTheme(
            darkTheme = isDarkTheme.value,
            content = {
                Scaffold(
                    topBar = { DefaultTopAppBar("Dogs home") }
                ) {
                    Column(Modifier.fillMaxWidth()) {
                        FullDogImage(url = "https://cdn2.thedogapi.com/images/BJa4kxc4X.jpg")
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            text = "Thats a simple app to fun with compose "
                        )
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            onClick = { navigator.push(DogsListScreen()) }
                        ) {
                            Text(text = "Dog breeds")
                        }
                        isDarkTheme.value = DarkThemeButton()
                    }
                }
            }
        )
    }
}

@Composable
fun DarkThemeButton(): Boolean {
    val checkedState = remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Checkbox(
            modifier = Modifier.align(Alignment.CenterVertically),
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it }
        )
        Text(modifier = Modifier.align(Alignment.CenterVertically), text = "Set to darkMode")
    }
    return checkedState.value
}
