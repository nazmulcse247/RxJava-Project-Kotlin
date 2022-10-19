package com.example.rxjavapractice

import com.example.rxjavapractice.apiservice.ApiInterface
import com.example.rxjavapractice.apiservice.RetrofitClient
import com.example.rxjavapractice.model.Meals
import io.reactivex.Single

class MealRepository {

    fun getMeal(s : String) : Single<Meals>{
        val apiConfig = RetrofitClient.getRetrofit().create(ApiInterface::class.java)
        return apiConfig.getMeal(s)
    }
}