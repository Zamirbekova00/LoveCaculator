package com.example.lovecaculator

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")

    fun percentageNames(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "626226ab71msh88b7146a81bb32ap12781bjsn9e72dd6b13d7",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ): retrofit2.Call<LoveModel>
}