package com.example.rxjavapractice

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavapractice.adapter.MealAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var mealViewModel: MealViewModel
    lateinit var adapter: MealAdapter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mealViewModel = ViewModelProvider(this).get(MealViewModel::class.java)
        val mealRv = findViewById<RecyclerView>(R.id.rvMeal)
        val mealPb = findViewById<ProgressBar>(R.id.pbMeal)

        mealPb.visibility = View.VISIBLE


        mealViewModel.getMeal("chicken").observe(this@MainActivity) {
            mealPb.visibility = View.GONE
            adapter = MealAdapter(it.meals, this@MainActivity)
            Toast.makeText(this, it.meals.size.toString(), Toast.LENGTH_LONG).show()
            val layoutManager = LinearLayoutManager(this@MainActivity)
            mealRv.layoutManager = layoutManager
            mealRv.adapter = adapter

        }
    }
}