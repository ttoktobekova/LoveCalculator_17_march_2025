package com.example.lovecalculator_17_march_2025.new_calculator.mvp

interface FlamesView {
    fun showResult(result:String)
    fun showError(message:String)
    fun showNetWorkError()
}