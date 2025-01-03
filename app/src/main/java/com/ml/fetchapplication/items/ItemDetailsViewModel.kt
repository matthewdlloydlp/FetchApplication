package com.ml.fetchapplication.items

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ml.fetchapplication.data.ItemRepository
import com.ml.fetchapplication.data.models.Item
import com.ml.fetchapplication.items.ItemDetailsUiState.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ItemDetailsViewModel @Inject constructor(
    private val itemRepository: ItemRepository
) : ViewModel() {

    val uiState: StateFlow<ItemDetailsUiState> =
        itemRepository.item.map<Item?, ItemDetailsUiState>(::Success)
            .catch {
                emit(ItemDetailsUiState.Error(it))
            }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                ItemDetailsUiState.Loading
            )
}

sealed interface ItemDetailsUiState {
    object Loading : ItemDetailsUiState
    data class Error(val throwable: Throwable) : ItemDetailsUiState
    data class Success(val data: Item?) : ItemDetailsUiState
}
