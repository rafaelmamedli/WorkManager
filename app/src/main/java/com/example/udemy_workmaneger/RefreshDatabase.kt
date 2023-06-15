package com.example.udemy_workmaneger

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class RefreshDatabase(val context: Context, workerParams: WorkerParameters) : Worker(context,
    workerParams
) {
    override fun doWork(): Result {
        val getData = inputData
        val myNumber = getData.getInt("intKey",0)
        refreshDataBase(myNumber)
        return Result.success()
    }

    fun refreshDataBase(myNumber: Int ){
        val sharedPreferences =context.getSharedPreferences("com.example.udemy_workmaneger",Context.MODE_PRIVATE)
        var mySavedNumber = sharedPreferences.getInt("myNumber",0)
        mySavedNumber = mySavedNumber + myNumber
        println(mySavedNumber)
        sharedPreferences.edit().putInt("myNumber",mySavedNumber).apply()
    }


}