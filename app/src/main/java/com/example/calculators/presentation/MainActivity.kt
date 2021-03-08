package com.example.calculators.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.calculators.R
import com.example.calculators.data.model.CalculatorRequest
import com.example.calculators.data.repository.CalculatorRepositoryPostImpl
import com.example.calculators.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
//    private lateinit var numb1: EditText
//    private lateinit var numb2: EditText
//    private lateinit var operator: EditText
//    private lateinit var results: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        initViewModel()
        binding.apply {
            hitung.setOnClickListener {
                val number1String = number1.text.toString()
                val number2String = number2.text.toString()
                val operatorString = operator.text.toString()
                val calNum = CalculatorRequest(
                    number1String,
                    number2String,
                    operatorString
                )
                viewModel.validation(calNum).observe(this@MainActivity,{
                    binding.hasil.text = it
                })
            }
        }

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this,object :ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val getRepo = CalculatorRepositoryPostImpl()
                return MainActivityViewModel(getRepo) as T
            }
        }).get(MainActivityViewModel::class.java)
    }




}