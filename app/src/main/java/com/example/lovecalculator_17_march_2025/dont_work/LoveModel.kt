package com.example.lovecalculator_17_march_2025.dont_work

import com.google.gson.annotations.SerializedName

data class LoveModel(
    @SerializedName("first name: ")
    val firstName: String,
    @SerializedName("second name: ")
    val secondName: String,
    @SerializedName("percentage match: ")
    val percentage: Double,
    @SerializedName("result: ||")
    val result: String
)
