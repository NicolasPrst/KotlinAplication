package com.project.kotlinaplication.Data.Local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.kotlinaplication.Data.Local.Models.UserLocal

@Database(entities = arrayOf(UserLocal::class),
    version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}