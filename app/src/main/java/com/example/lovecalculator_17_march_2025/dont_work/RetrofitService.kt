package com.example.lovecalculator_17_march_2025.dont_work

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private var retrofit = Retrofit.Builder()
        .baseUrl("https://the-love-calculator.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(LoveApi::class.java)
}