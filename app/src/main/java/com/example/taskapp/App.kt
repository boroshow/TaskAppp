package com.example.taskapp

import android.app.Application
import androidx.room.Room
import com.example.taskapp.data.AppDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    companion object {
        lateinit var appDatabase: AppDatabase
    }
}