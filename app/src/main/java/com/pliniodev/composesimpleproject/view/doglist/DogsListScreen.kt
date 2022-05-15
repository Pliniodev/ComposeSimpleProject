package com.pliniodev.composesimpleproject.view.doglist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.pliniodev.composesimpleproject.presentation.model.BreedPresentation
import com.pliniodev.composesimpleproject.view.DogsScreenModel
import com.pliniodev.composesimpleproject.view.component.ShowProgress
import com.pliniodev.composesimpleproject.view.component.default.DefaultTopAppBar

class DogsListScreen : Screen {

    @Composable
    override fun Content() {

        val screenModel = getScreenModel<DogsScreenModel>()
        val state by screenModel.state.collectAsState()

        screenModel.getBreedsList(1)

        Scaffold(
            topBar = { DefaultTopAppBar("Dog breeds") }
        ) {
            when (val result = state) {
                is DogsScreenModel.State.Loading -> ShowProgress()
                is DogsScreenModel.State.Result -> DogsList(result.breed)
            }
        }
    }
}

@Composable
fun DogsList(dogs: List<BreedPresentation>) {
    LazyColumn {
        items(dogs) { breed ->
            DogCardEntry(breedPresentation = breed)
        }
    }
}
