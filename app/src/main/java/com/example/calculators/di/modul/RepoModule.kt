package com.example.calculators.di.modul

import com.example.calculators.data.repository.CalculatorRepository
import com.example.calculators.data.repository.CalculatorRepositoryPostImpl
import com.example.calculators.di.qualifier.CalculatorApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {
    @CalculatorApi
    @Binds
    abstract fun bindsRepositoryApi(calculatorRepositoryPostImpl: CalculatorRepositoryPostImpl):CalculatorRepository
}