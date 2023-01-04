package com.example.rxjavapractice.model

import com.google.gson.annotations.SerializedName

 class Meals {

     @SerializedName("meals")
      var meals: List<Meal> = ArrayList()
 }