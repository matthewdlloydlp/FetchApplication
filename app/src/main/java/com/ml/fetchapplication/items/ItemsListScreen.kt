package com.ml.fetchapplication.items

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ml.fetchapplication.data.models.FetchList
import com.ml.fetchapplication.data.models.Item
import com.ml.fetchapplication.data.models.groupByListId
import com.ml.fetchapplication.ui.theme.FetchApplicationTheme

@Composable
fun ItemsListScreen(
    modifier: Modifier = Modifier,
    viewModel: ItemsListViewModel = hiltViewModel()
) {
    val lists by viewModel.uiState.collectAsStateWithLifecycle()

    when(lists) {
        is ItemUiState.Success -> {
            ItemsListScreen(
                lists = (lists as ItemUiState.Success).data,
                modifier = modifier
            )
        }
        is ItemUiState.Error -> {
            Text((lists as ItemUiState.Error).throwable.message.orEmpty())
        }
        ItemUiState.Loading -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(100.dp)
            ) {
                CircularProgressIndicator()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun ItemsListScreen(
    lists: List<FetchList>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        lists.forEach {
            val items = it.items
            stickyHeader {
                Text(
                    text = "List: ${it.listId}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                        .padding(16.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
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
        ItemsListScreen(fakeItems.groupByListId())
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
