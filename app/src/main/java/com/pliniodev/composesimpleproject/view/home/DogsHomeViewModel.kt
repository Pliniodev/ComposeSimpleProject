package com.pliniodev.composesimpleproject.view.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pliniodev.composesimpleproject.domain.repository.DogsApiRepository
import com.pliniodev.composesimpleproject.presentation.model.BreedPresentation
import com.pliniodev.composesimpleproject.presentation.model.HeightPresentation
import com.pliniodev.composesimpleproject.presentation.model.ImagePresentation
import com.pliniodev.composesimpleproject.presentation.model.WeightPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class DogsHomeViewModel(
    private val api: DogsApiRepository
) : ViewModel() {

    val dogsList = mutableStateOf<List<BreedPresentation>>(listOf())

    private val _breedsByPage = MutableLiveData<List<BreedPresentation>>()
    val breeds: LiveData<List<BreedPresentation>> = _breedsByPage

    private val _errorMsg = MutableLiveData<String>()
    val errorMsg: LiveData<String> = _errorMsg

    init {
        getBreedsList(1)
    }

    private fun getBreedsList(page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                api.getBreeds(page)
            }.onSuccess { breedPresentations ->
                dogsList.value = breedPresentations
            }.onFailure { exception ->
                _errorMsg.postValue(exception.message)
            }
        }
    }
}
