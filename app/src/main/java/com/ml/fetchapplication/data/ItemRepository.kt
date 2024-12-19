package com.ml.fetchapplication.data

import com.ml.fetchapplication.data.models.Item
import com.ml.fetchapplication.network.ItemService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

interface ItemRepository {
    val items: Flow<List<Item>>

    suspend fun fetchItems()
}

class DefaultItemRepository @Inject constructor(
    private val itemService: ItemService
) : ItemRepository {

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    override val items: Flow<List<Item>> = _items

    override suspend fun fetchItems() {
        try {
            val response = itemService.getItems()
            if (response.isSuccessful) {
                _items.emit(
                    response.body()?.filter { !it.name.isNullOrBlank() } ?: emptyList()
                )
            } else {
                // Handle error
            }
        } catch (e: Exception) {
            // Handle exception
        }
    }

}

