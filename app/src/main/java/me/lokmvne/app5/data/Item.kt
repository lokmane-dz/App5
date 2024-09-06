package me.lokmvne.app5.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "Item",
    indices = [Index(value = ["CodeBar"], unique = true)]
)
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val CodeBar: Int,
    val Title: String,
    val Price: Float,
    val Quantity: Int,
)
