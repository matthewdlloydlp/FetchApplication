package com.ml.fetchapplication.items

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ml.fetchapplication.ui.theme.FetchApplicationTheme
import com.ml.fetchapplication.R
import com.ml.fetchapplication.data.models.FetchList
import com.ml.fetchapplication.data.models.Item
import com.ml.fetchapplication.data.models.groupByListId

@Composable
fun ItemsListScreen(
    modifier: Modifier = Modifier,
    viewModel: ItemsListViewModel = hiltViewModel(),
    onItemClicked: (Item) -> Unit = {}
) {
    val lists by viewModel.uiState.collectAsStateWithLifecycle()

    when (lists) {
        is ItemListUiState.Success -> {
            ItemsListScreen(
                lists = (lists as ItemListUiState.Success).data,
                {
                    viewModel.onItemClicked(it)
                    onItemClicked(it)
                },
                modifier = modifier
            )
        }

        is ItemListUiState.Error -> {
            Text((lists as ItemListUiState.Error).throwable.message.orEmpty())
        }

        ItemListUiState.Loading -> {
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
    onItemClicked: (Item) -> Unit = {},
    modifier: Modifier = Modifier
) {
    val expandedIds = remember { lists.map { it.listId }.toMutableStateList() }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        lists.forEach { fetchList ->
            val items = fetchList.items
            val listId = fetchList.listId
            stickyHeader {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            if (expandedIds.contains(listId)) {
                                expandedIds.remove(listId)
                            } else {
                                expandedIds.add(listId)
                            }
                        }
                ) {
                    Text(
                        text = stringResource(R.string.list_title, listId),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.primary)
                            .padding(16.dp),
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center
                    )
                }
            }
            if (expandedIds.contains(listId)) {
                items(items.size,
                    { index ->
                        items[index].id
                    }
                ) { index ->
                    val item = items[index]
                    ItemRow(item, onItemClicked)
                }
            }
        }
    }
}

@Composable
fun ItemRow(item: Item, onItemClicked: (Item) -> Unit = {}) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        onClick = {
            onItemClicked(item)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(vertical = 8.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = item.name.orEmpty(),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.weight(1f)
            )
            Column {
                Text(
                    text = stringResource(R.string.item_id, item.id),
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = stringResource(R.string.item_list_id, item.listId),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
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
