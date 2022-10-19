package com.example.rxjavapractice.model

import com.google.gson.annotations.SerializedName

class Meal {
    @SerializedName("idMeal")
    lateinit var idMeal: String

    @SerializedName("strMeal")
    lateinit var strMeal: String

    @SerializedName("strMealThumb")
    lateinit var strMealThumb: String
}
