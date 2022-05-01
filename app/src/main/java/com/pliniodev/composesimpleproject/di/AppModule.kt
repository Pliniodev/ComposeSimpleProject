package com.pliniodev.composesimpleproject.di

import com.pliniodev.composesimpleproject.data.DogsGateway
import com.pliniodev.composesimpleproject.data.DogsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDogsService(
        api: DogsGateway
    ) = DogsRepository(api)

    @Singleton
    @Provides
    fun provideDogsApi(): DogsGateway {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.thedogapi.com/v1/")
            .build()
            .create(DogsGateway::class.java)
    }
}