package com.pliniodev.composesimpleproject.view.doglist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import cafe.adriel.voyager.core.screen.Screen
import com.pliniodev.composesimpleproject.view.doglist.DogCardEntry
import com.pliniodev.composesimpleproject.presentation.model.BreedPresentation
import org.koin.androidx.compose.getViewModel

class DogsListScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel = getViewModel<DogsListViewModel>()

        val dogs by remember { viewModel.dogsList }

//        DogsList(dogs)
        LazyColumn {
            items(dogs) { breed ->
                DogCardEntry(breedPresentation = breed)
            }
        }
    }
}

@Composable
fun DogsList(dogs: List<BreedPresentation>){
    LazyColumn {
        items(dogs) { breed ->
            DogCardEntry(breedPresentation = breed)
        }
    }
}
