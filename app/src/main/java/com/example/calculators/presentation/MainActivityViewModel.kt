package com.example.calculators.presentation

import android.util.Log
import androidx.lifecycle.*
import com.example.calculators.data.api.CalculatorApi
import com.example.calculators.data.model.CalculatorRequest
import com.example.calculators.data.model.CalculatorResponse
import com.example.calculators.data.repository.CalculatorRepository
import com.example.calculators.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withTimeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivityViewModel(val repository: CalculatorRepository) : ViewModel() {

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


//    fun calculate(request: CalculatorRequest) {
//        when(request.operator){
//            "+", "-", "/", "*" -> {
//                val retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
//                    .addConverterFactory(MoshiConverterFactory.create()).build()
//                val service = retrofit.create((CalculatorApi::class.java))
//                val call = service.postCalculate(request)
//                call.enqueue(object : Callback<CalNumResponse> {
//                    override fun onFailure(call: Call<CalNumResponse>, t: Throwable) {
//                        Log.d("Calculatorview", t.toString())
//                    }
//
//                    override fun onResponse(
//                        call: Call<CalNumResponse>,
//                        response: Response<CalNumResponse>
//                    ) {
//                        val respon = response.body()!!
//                        val output =
//                            "Number 1 : ${respon.number1}, Number 2 : ${respon.number2}, Operator : ${respon.operator}, Result : ${respon.result}"
//                        _mutableResult.value = output
//                    }
//                })
//            }
//
//            else -> _mutableResult.value = "error"
//
//
//        }
//
//
//    }
