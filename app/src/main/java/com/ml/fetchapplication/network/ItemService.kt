package com.ml.fetchapplication.network


import com.ml.fetchapplication.data.models.Item
import retrofit2.Response
import retrofit2.http.GET

interface ItemService {
    @GET("hiring.json")
    suspend fun getItems(): Response<List<Item>>
}