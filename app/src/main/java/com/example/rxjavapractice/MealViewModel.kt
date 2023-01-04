package com.example.rxjavapractice

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxjavapractice.model.Meals
import io.reactivex.Scheduler
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Schedulers.io

class MealViewModel(application: Application) : AndroidViewModel(application) {

    private var mealRepository : MealRepository
    private val compositDisposable : CompositeDisposable

    init {
        mealRepository = MealRepository()
        compositDisposable = CompositeDisposable()
    }

    fun getMeal(s : String) : MutableLiveData<Meals>{

        val mlResponse = MutableLiveData<Meals>()

        mealRepository.getMeal(s)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Meals>{
                override fun onSubscribe(d: Disposable) {
                    compositDisposable.add(d)
                }

                override fun onSuccess(reponse: Meals) {
                    mlResponse.value = reponse
                }

                override fun onError(e: Throwable) {
                    Log.d(TAG, "onError: "+ e.localizedMessage)
                }

            })

        return mlResponse
    }
}