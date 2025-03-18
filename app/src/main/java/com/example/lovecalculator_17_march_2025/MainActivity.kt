package com.example.lovecalculator_17_march_2025

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.lovecalculator_17_march_2025.databinding.ActivityMainBinding
import com.example.lovecalculator_17_march_2025.dont_work.LoveModel
import com.example.lovecalculator_17_march_2025.mvp.LoveView
import com.example.lovecalculator_17_march_2025.mvp.Presenter
import com.example.lovecalculator_17_march_2025.new_calculator.FlamesApiClient
import com.example.lovecalculator_17_march_2025.new_calculator.FlamesResponse
import com.example.lovecalculator_17_march_2025.new_calculator.mvp.FlamesView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), LoveView, FlamesView {
    private lateinit var binding: ActivityMainBinding
    private val presenter = Presenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnFlames()
//        btnLoveCalculator()
    }

    private fun btnLoveCalculator() {
        binding.btnResult.setOnClickListener {
            presenter.getLoveData(
                binding.etFirstName.text.toString(),
                binding.etSecondName.text.toString()
            )
        }
    }

    private fun btnFlames() {
        binding.btnResult.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val secondName = binding.etSecondName.text.toString()

            if (firstName.isNotEmpty() && secondName.isNotEmpty()) {
                getFlamesResult(firstName, secondName)
            } else {
                binding.tvResult.text = "Пожалуйста, заполните оба поля."
            }
        }
    }

    private fun getFlamesResult(firstName: String, secondName: String) {
        val request = FlamesApiClient.service.getFlamesResult(firstName, secondName)
        request.enqueue(object : Callback<FlamesResponse> {
            override fun onResponse(
                call: Call<FlamesResponse>,
                response: Response<FlamesResponse>
            ) {
                if (response.isSuccessful) {
                    binding.tvResult.text = "Результат: ${response.body()?.result}"
                } else {
                    Log.e("FLAMES_ERROR", "Ошибка: ${response.code()}")
                    binding.tvResult.text = "Ошибка при получении результата."
                }
            }

            override fun onFailure(call: Call<FlamesResponse>, t: Throwable) {
                Log.e("FLAMES_ERROR", "Ошибка сети: ${t.message}")
                binding.tvResult.text = "Ошибка сети. Попробуйте снова."
            }
        })
    }

    override fun showResult(loveModel: LoveModel) {
        binding.tvResult.text = loveModel.toString()
    }

    override fun showResult(result: String) {
        binding.tvResult.text = "Result: $result"
    }

    override fun showError(message: String) {
        binding.tvResult.text = "Result: $message"
    }

    override fun showNetWorkError() {
        binding.tvResult.text = "Error network. Try again"
    }
}
