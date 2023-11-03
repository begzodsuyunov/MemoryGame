package com.example.memorygame.app

import android.app.Application
import com.example.memorygame.data.shp.MySharedPreference
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        MySharedPreference.init(this)
    }
}