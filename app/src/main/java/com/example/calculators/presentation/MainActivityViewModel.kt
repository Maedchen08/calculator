package com.example.calculators.presentation

import android.util.Log
import androidx.lifecycle.*
import com.example.calculators.data.model.CalculatorRequest
import com.example.calculators.data.model.CalculatorResponse
import com.example.calculators.data.repository.CalculatorRepository
import com.example.calculators.di.qualifier.CalculatorApi
import com.example.calculators.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withTimeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

@HiltViewModel

class MainActivityViewModel @Inject constructor(@CalculatorApi val repository: CalculatorRepository) : ViewModel() {

//    private var _mutableResult = MutableLiveData<String>()
//    val mutableResult : LiveData<String>
//    get() {
//        return _mutableResult
//    }

    fun postCalculateCount(calculatorRequest: CalculatorRequest) =
        liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
            withTimeout(1000) {
                try {
                    val response = repository.onCount(calculatorRequest)
                    val eka = response.body()!!
                    emit(eka.result)
                } catch (e: Exception) {
                    Log.d("Calc", e.toString())
                    emit("error")
                }
            }
        }

    fun validation(request: CalculatorRequest, ) =
        when (request.operator) {
            "+", "-", "*", "/" ->   postCalculateCount(request)
            else ->  liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
                withTimeout(1000) {
                    try {
                        emit("Wrong Operator")
                    } catch (e: Exception) {
                        Log.d("Calc", e.toString())
                        emit("error")
                    }
                }
            }
        }
    }



