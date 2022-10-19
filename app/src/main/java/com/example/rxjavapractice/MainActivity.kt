package com.example.rxjavapractice

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    private lateinit var mealViewModel: MealViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mealViewModel = ViewModelProvider(this).get(MealViewModel::class.java)

        mealViewModel.getMeal("chicken").observe(this,{
            Log.e("meal", "rxjava" + it.meals.toString())
            Toast.makeText(this,""+it.meals.get(1).strMeal,Toast.LENGTH_LONG).show()
            it.meals.forEach {
                System.out.println(it)
            }
        })
    }
}