package com.ml.fetchapplication.data

import com.ml.fetchapplication.data.models.FetchList
import com.ml.fetchapplication.data.models.Item
import com.ml.fetchapplication.data.models.groupByListId
import com.ml.fetchapplication.network.ItemService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

interface ItemRepository {
    val lists: Flow<List<FetchList>>
    val item: Flow<Item?>

    suspend fun fetchItems()
    suspend fun setItem(item: Item?)
}

class DefaultItemRepository @Inject constructor(
    private val itemService: ItemService
) : ItemRepository {

    private val _lists = MutableSharedFlow<List<FetchList>>()
    override val lists: Flow<List<FetchList>> = _lists

    // Not sure I love this, in the future probably save the list to a room database and then
    // on the details page query by item id
    private val _item = MutableStateFlow<Item?>(null)
    override val item: Flow<Item?> = _item

    override suspend fun fetchItems() {
        try {
            val response = itemService.getItems()
            if (response.isSuccessful) {
                _lists.emit(
                    response.body()?.filter {
                        !it.name.isNullOrBlank()
                    }.groupByListId()
                )
            } else {
                // Handle error
            }
        } catch (e: Exception) {
            // Handle exception
        }
    }

    override suspend fun setItem(item: Item?) {
        _item.emit(item)
    }

}

