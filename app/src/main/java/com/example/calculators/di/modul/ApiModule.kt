package com.example.calculators.di.modul

import com.example.calculators.data.api.CalculatorApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Singleton
    @Provides
    fun provideCalculatorApi(retrofit: Retrofit):CalculatorApi {
        return retrofit.create(CalculatorApi::class.java)
    }
}