package me.lokmvne.app5.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1)
abstract class ItemDB : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}