package com.example.calculators.data.repository

import com.example.calculators.data.api.RetrofitInstance
import com.example.calculators.data.model.CalculatorRequest
import com.example.calculators.data.model.CalculatorResponse

class CalculatorRepositoryPostImpl : CalculatorRepository {
    override suspend fun onCount(calculatorRequest: CalculatorRequest) =
        RetrofitInstance.calculatorApi.postCalculate(calculatorRequest)
}