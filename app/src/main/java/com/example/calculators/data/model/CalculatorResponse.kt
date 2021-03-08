package com.example.calculators.data.model

data class CalculatorResponse constructor(
    var number1: String,
    var number2: String,
    val operator: String,
    val result: String
)