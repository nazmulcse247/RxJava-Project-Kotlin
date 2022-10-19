package com.example.rxjavapractice.apiservice

import com.example.rxjavapractice.model.Meals
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("api/json/v1/1/search.php")
    fun getMeal(
        @Query("s") query : String
    ) : Single<Meals>
}