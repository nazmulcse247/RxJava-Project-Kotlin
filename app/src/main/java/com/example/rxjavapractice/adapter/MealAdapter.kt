package com.example.rxjavapractice.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.rxjavapractice.R
import com.example.rxjavapractice.databinding.MealItemBinding
import com.example.rxjavapractice.model.Meal

class MealAdapter(var mealList : List<Meal> , val context : Context) : Adapter<MealAdapter.MealViewHolder>() {

//    class DiffUtill : DiffUtil.ItemCallback<Meal>(){
//        override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
//            return oldItem.idMeal == newItem.idMeal
//        }
//
//        @SuppressLint("DiffUtilEquals")
//        override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
//            return oldItem == newItem
//        }
//
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val binding = LayoutInflater.from(context).inflate(R.layout.meal_item,parent,false)
        return MealViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {

       //val mealItem = mealList[position]
        holder.mealIdTv.text = mealList.get(position).idMeal
        holder.mealNameTv.text = mealList.get(position).strMeal

        Glide.with(context).load(mealList.get(position).strMealThumb).into(holder.mealIv)

    }



    inner class MealViewHolder(itemView: View) : ViewHolder(itemView){

        val mealIv = itemView.findViewById<ImageView>(R.id.ivMeal)
        val mealIdTv = itemView.findViewById<TextView>(R.id.tvMealId)
        val mealNameTv = itemView.findViewById<TextView>(R.id.tvMealName)

    }

    override fun getItemCount(): Int {
        return mealList.size
    }
}