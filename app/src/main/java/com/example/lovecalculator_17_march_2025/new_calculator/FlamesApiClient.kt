package com.example.lovecalculator_17_march_2025.new_calculator

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FlamesApiClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://flames-love-calculator.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: FlamesApiService = retrofit.create(FlamesApiService::class.java)
}
