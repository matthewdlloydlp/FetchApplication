package com.ml.fetchapplication.data.models

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("id")
    val id: Int,
    @SerializedName("listId")
    val listId: Int,
    @SerializedName("name")
    val name: String? = null
)

fun List<Item>?.groupByListId(): List<FetchList> {
    val fetchList = mutableListOf<FetchList>()
    this?.groupBy {
        it.listId
    }?.forEach {
        // sort the grouped lists by name
        fetchList.add(FetchList(it.key, it.value.sortedBy { it.name }))
    }
    return fetchList.sortedBy { it.listId }
}
