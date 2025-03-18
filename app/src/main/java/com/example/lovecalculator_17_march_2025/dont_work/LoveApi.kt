package com.example.lovecalculator_17_march_2025.dont_work

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    //https://the-love-calculator.p.rapidapi.com/love-calculator?fname=James&sname=Asel
    @GET("love-calculator")
    fun getLove(
        @Query("second name: ") secondName: String,
        @Query("first name: ") firstName: String,
        @Header("X-RapidAPI-Key") key: String = "e6eb10b8b5msh44de7b3fb08dee3p1235c9jsn5855c92318a6",
        @Header("X-RapidAPI-Host") host: String = "the-love-calculator.p.rapidapi.com"
    ): Call<LoveModel>
}