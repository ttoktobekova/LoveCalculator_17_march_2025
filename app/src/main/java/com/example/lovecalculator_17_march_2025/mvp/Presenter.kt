package com.example.lovecalculator_17_march_2025.mvp

import com.example.lovecalculator_17_march_2025.dont_work.LoveModel
import com.example.lovecalculator_17_march_2025.dont_work.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter(private val view: LoveView) {
    val api = RetrofitService.api
    fun getLoveData(firstName: String, secondName: String) {
        api.getLove(
            firstName = firstName,
            secondName = secondName
        ).enqueue(object : Callback<LoveModel> {
            override fun onResponse(p0: Call<LoveModel>, response: Response<LoveModel>) {
                response.body()?.let { model ->
                    view.showResult(model)
                }
                }
            override fun onFailure(p0: Call<LoveModel>, p1: Throwable) {

            }
        })
    }
}