package com.ml.fetchapplication.items

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ml.fetchapplication.data.ItemRepository
import com.ml.fetchapplication.data.models.FetchList
import com.ml.fetchapplication.data.models.Item
import com.ml.fetchapplication.items.ItemListUiState.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsListViewModel @Inject constructor(
    private val itemRepository: ItemRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            itemRepository.fetchItems()
        }
    }

    val uiState: StateFlow<ItemListUiState> =
        itemRepository.lists.map<List<FetchList>, ItemListUiState>(::Success)
            .catch {
                emit(ItemListUiState.Error(it))
            }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                ItemListUiState.Loading
            )

    fun onItemClicked(item: Item) {
        viewModelScope.launch {
            itemRepository.setItem(item)
        }
    }
}

sealed interface ItemListUiState {
    object Loading : ItemListUiState
    data class Error(val throwable: Throwable) : ItemListUiState
    data class Success(val data: List<FetchList>) : ItemListUiState
}
