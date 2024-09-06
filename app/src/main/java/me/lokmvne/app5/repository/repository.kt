package me.lokmvne.app5.repository

import me.lokmvne.app5.data.Item
import me.lokmvne.app5.data.ItemDao
import javax.inject.Inject

class repository @Inject constructor(private val dao: ItemDao) {
    suspend fun GetAllItems() = dao.getAll()
    suspend fun AddItem(item: Item) = dao.AddItem(item)
}