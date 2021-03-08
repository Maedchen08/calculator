package com.example.calculators.data.api

import com.example.calculators.data.model.CalculatorRequest
import com.example.calculators.data.model.CalculatorResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface CalculatorApi {

    @POST("calculate")
    suspend fun postCalculate(
        @Body request : CalculatorRequest
    ): Response<CalculatorResponse>
}