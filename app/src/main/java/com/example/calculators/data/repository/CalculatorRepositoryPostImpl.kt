package com.example.calculators.data.repository

import com.example.calculators.data.api.CalculatorApi
import com.example.calculators.data.model.CalculatorRequest
import javax.inject.Inject

class CalculatorRepositoryPostImpl @Inject constructor(val calculatorApi: CalculatorApi) : CalculatorRepository {
    override suspend fun onCount (calculatorRequest: CalculatorRequest) =
       calculatorApi.postCalculate(calculatorRequest)
}