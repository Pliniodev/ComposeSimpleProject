package com.pliniodev.composesimpleproject.view.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import com.pliniodev.composesimpleproject.view.component.BreedCardEntry
import com.pliniodev.composesimpleproject.di.dogsModule
import com.pliniodev.composesimpleproject.presentation.model.BreedPresentation
import com.pliniodev.composesimpleproject.presentation.model.HeightPresentation
import com.pliniodev.composesimpleproject.presentation.model.ImagePresentation
import com.pliniodev.composesimpleproject.presentation.model.WeightPresentation
import org.koin.androidx.compose.getViewModel
import org.koin.core.context.loadKoinModules

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel = getViewModel<DogsHomeViewModel>()

        val dogs by remember { viewModel.dogsList }

        DogsList(dogs)
    }
}

@Composable
fun DogsList(dogs: List<BreedPresentation>){
    LazyColumn {
        items(dogs) { breed ->
            BreedCardEntry(breed = breed)
        }
    }
}
