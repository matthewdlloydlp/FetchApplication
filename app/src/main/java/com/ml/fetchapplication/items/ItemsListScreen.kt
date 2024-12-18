package com.ml.fetchapplication.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ml.fetchapplication.ui.theme.FetchApplicationTheme

@Composable
fun ItemsListScreen(modifier: Modifier = Modifier, viewModel: OrderViewModel = hiltViewModel()) {
    val items by viewModel.uiState.collectAsStateWithLifecycle()
    if (items is OrderUiState.Success) {
        OrderScreen(
            items = (items as OrderUiState.Success).data,
            onSave = viewModel::addOrder,
            modifier = modifier
        )
    } else {
        Text("error")
    }
}

@Composable
internal fun ItemsListScreen(
    items: List<String>,
    onSave: (name: String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        var nameOrder by remember { mutableStateOf("Compose") }
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextField(
                value = nameOrder,
                onValueChange = { nameOrder = it }
            )

            Button(modifier = Modifier.width(96.dp), onClick = { onSave(nameOrder) }) {
                Text("Save")
            }
        }
        items.forEach {
            Text("Saved item: $it")
        }
    }
}

// Previews

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    FetchApplicationTheme {  } {
        ItemsListScreen(listOf("Compose", "Room", "Kotlin"), onSave = {})
    }
}