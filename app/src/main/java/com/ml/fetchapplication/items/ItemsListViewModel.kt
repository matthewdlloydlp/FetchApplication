package com.ml.fetchapplication.items

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ml.fetchapplication.data.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ItemsListViewModel @Inject constructor(
    private val itemRepository: ItemRepository
) : ViewModel() {

    val uiState: StateFlow<OrderUiState> = orderRepository
        .orders.map<List<String>, OrderUiState>(::Success)
        .catch {
            Log.d("matt123", it.message?:"error")
            emit(Error(it))
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Loading)


}

sealed interface OrderUiState {
    object Loading : OrderUiState
    data class Error(val throwable: Throwable) : OrderUiState
    data class Success(val data: List<String>) : OrderUiState
}
