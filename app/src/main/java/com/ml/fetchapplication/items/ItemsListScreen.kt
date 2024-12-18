package com.ml.fetchapplication.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ml.fetchapplication.data.models.Item
import com.ml.fetchapplication.ui.theme.FetchApplicationTheme

@Composable
fun ItemsListScreen(
    modifier: Modifier = Modifier,
    viewModel: ItemsListViewModel = hiltViewModel()
) {
    val items by viewModel.uiState.collectAsStateWithLifecycle()
    if (items is ItemUiState.Success) {
        ItemsListScreen(
            items = (items as ItemUiState.Success).data,
            modifier = modifier
        )
    } else {
        Text("error")
    }
}

@Composable
internal fun ItemsListScreen(
    items: List<Item>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(items.size,
            { index ->
                items[index].id
            }
        ) { index ->
            val item = items[index]
            ItemRow(item)
        }
    }
}

@Composable
fun ItemRow(item: Item) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(text = "ID: ${item.id}")
        Text(text = "List ID: ${item.listId}")
        Text(
            text = "Name: ${item.name}",
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}


// Previews

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    FetchApplicationTheme {
        ItemsListScreen(fakeItems)
    }
}

val fakeItems = listOf(
    Item(333, 3, "Item 333"),
    Item(123, 1, null),
    Item(222, 2, "Item 222"),
    Item(111, 1, "Item 111"),
    Item(345, 3, null),
    Item(654, 6, "Item 111"),
)
