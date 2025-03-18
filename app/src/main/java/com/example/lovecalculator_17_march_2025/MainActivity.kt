package com.example.lovecalculator_17_march_2025

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.lovecalculator_17_march_2025.databinding.ActivityMainBinding
import com.example.lovecalculator_17_march_2025.new_calculator.FlamesApiClient
import com.example.lovecalculator_17_march_2025.new_calculator.FlamesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
}
