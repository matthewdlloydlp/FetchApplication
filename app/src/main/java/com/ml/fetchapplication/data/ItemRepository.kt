package com.ml.fetchapplication.data

import com.ml.fetchapplication.data.models.FetchList
import com.ml.fetchapplication.data.models.groupByListId
import com.ml.fetchapplication.network.ItemService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

interface ItemRepository {
    val lists: Flow<List<FetchList>>

    suspend fun fetchItems()
}

class DefaultItemRepository @Inject constructor(
    private val itemService: ItemService
) : ItemRepository {

    private val _lists = MutableStateFlow<List<FetchList>>(emptyList())
    override val lists: Flow<List<FetchList>> = _lists

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

}

