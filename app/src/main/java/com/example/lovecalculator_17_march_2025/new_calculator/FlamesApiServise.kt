package com.example.lovecalculator_17_march_2025.new_calculator

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface FlamesApiService {
    @Headers(
        "X-RapidAPI-Key: e6eb10b8b5msh44de7b3fb08dee3p1235c9jsn5855c92318a6",
        "X-RapidAPI-Host: flames-love-calculator.p.rapidapi.com"
    )
    @GET("flame/{name1}/{name2}")
    fun getFlamesResult(
        @Path("name1") name1: String,
        @Path("name2") name2: String
    ): Call<FlamesResponse>
}
