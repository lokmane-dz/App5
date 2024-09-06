package me.lokmvne.app5.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun AddItem(myItem: Item): Long

    @Query("SELECT * FROM Item ORDER BY id ASC")
    suspend fun getAll(): List<Item>


    @Query("SELECT * FROM Item WHERE CodeBar = :CodeBar")
    suspend fun getItemByCodeBar(CodeBar: Int): Item
}