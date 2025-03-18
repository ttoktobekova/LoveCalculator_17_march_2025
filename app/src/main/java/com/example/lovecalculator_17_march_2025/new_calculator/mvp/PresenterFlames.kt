package com.example.lovecalculator_17_march_2025.new_calculator.mvp

import com.example.lovecalculator_17_march_2025.new_calculator.FlamesApiService
import com.example.lovecalculator_17_march_2025.new_calculator.FlamesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterFlames(private val view: FlamesView, private val apiService: FlamesApiService) {
    fun calculateFlames(firstName: String, secondName: String) {
        if (firstName.isEmpty() || secondName.isEmpty()) {
            view.showError("Please, fill in both fields")
            return
        }
        val request = apiService.getFlamesResult(firstName, secondName)
        request.enqueue(object : Callback<FlamesResponse> {
            override fun onResponse(p0: Call<FlamesResponse>, response: Response<FlamesResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let { model ->
                        view.showResult(model.result)
                    } ?: view.showError("Error,data processing")
                } else {
                    view.showError("Error ${response.code()}")
                }
            }

            override fun onFailure(p0: Call<FlamesResponse>, p1: Throwable) {
                view.showNetWorkError()
            }

        })

    }
}