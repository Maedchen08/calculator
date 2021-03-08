package com.example.calculators.data.repository

import com.example.calculators.data.model.CalculatorRequest
import com.example.calculators.data.model.CalculatorResponse
import retrofit2.Response

interface CalculatorRepository {
    suspend fun onCount(calculatorRequest: CalculatorRequest): Response<CalculatorResponse>
}