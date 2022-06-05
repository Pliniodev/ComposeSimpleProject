package com.pliniodev.composesimpleproject.view.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Nightlight
import androidx.compose.material.icons.twotone.WbSunny
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.pliniodev.composesimpleproject.view.component.FullDogImage
import com.pliniodev.composesimpleproject.view.doglist.DogsListScreen

class DogsHome(private val isDarkTheme: MutableState<Boolean>) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = {
                val materialBlue700 = Color(0xFF1976D2)
                TopAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    title = { Text("Dogs home") },
                    backgroundColor = materialBlue700,
                    actions = {
                        IconButton(onClick = { isDarkTheme.value = isDarkTheme.value.not() }) {
                            if (isDarkTheme.value) {
                                Icon(Icons.TwoTone.WbSunny, "")
                            } else {
                                Icon(Icons.TwoTone.Nightlight, "")
                            }
                        }
                    }
                )
            }
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
            }
        }
    }
}
