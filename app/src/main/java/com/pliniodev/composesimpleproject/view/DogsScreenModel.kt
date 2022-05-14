package com.pliniodev.composesimpleproject.view

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.pliniodev.composesimpleproject.domain.repository.DogsApiRepository
import com.pliniodev.composesimpleproject.presentation.model.BreedPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class DogsScreenModel(
    private val api: DogsApiRepository
) : StateScreenModel<DogsScreenModel.State>(State.Init) {

    sealed class State {
        object Init : State()
        data class Result(val breed: List<BreedPresentation>) : State()
    }

    fun getBreedsList(page: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            mutableState.value = State.Result(api.getBreeds(page))
        }
    }
}
