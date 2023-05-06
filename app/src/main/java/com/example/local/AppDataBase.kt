package com.example.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase:RoomDatabase() {

    abstract fun getDao():LoveDao
}