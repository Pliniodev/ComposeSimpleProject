package com.pliniodev.composesimpleproject.domain.repository

import com.pliniodev.composesimpleproject.presentation.model.BreedPresentation


internal interface DogsApiRepository {
    suspend fun getBreeds(page: Int): List<BreedPresentation>
}
