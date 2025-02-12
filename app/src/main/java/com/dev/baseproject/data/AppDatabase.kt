package com.dev.baseproject.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dev.baseproject.data.dao.ClickerDao
import com.dev.baseproject.data.entity.ClickerEntity

@Database(
    entities = [ClickerEntity::class], version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clickerDao(): ClickerDao
}