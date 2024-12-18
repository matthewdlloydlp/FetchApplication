package com.ml.fetchapplication.items

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ml.fetchapplication.data.ItemRepository
import com.ml.fetchapplication.data.models.Item
import com.ml.fetchapplication.items.ItemUiState.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ItemsListViewModel @Inject constructor(
    private val itemRepository: ItemRepository
) : ViewModel() {

    val uiState: StateFlow<ItemUiState> =
        itemRepository.items.map<List<Item>, ItemUiState>(::Success)
            .catch {
                Log.d("matt123", it.message ?: "error")
                emit(ItemUiState.Error(it))
            }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                ItemUiState.Loading
            )


}

sealed interface ItemUiState {
    object Loading : ItemUiState
    data class Error(val throwable: Throwable) : ItemUiState
    data class Success(val data: List<Item>) : ItemUiState
}
