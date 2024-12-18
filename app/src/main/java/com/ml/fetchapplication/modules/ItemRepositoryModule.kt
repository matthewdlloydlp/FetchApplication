package com.ml.fetchapplication.modules

import com.ml.fetchapplication.data.DefaultItemRepository
import com.ml.fetchapplication.data.ItemRepository
import com.ml.fetchapplication.data.models.Item
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ItemRepositoryModule {

    @Singleton
    @Binds
    fun bindsItemRepository(
        orderRepository: DefaultItemRepository
    ): ItemRepository
}

class FakeItemRepository @Inject constructor() : ItemRepository {
    override val items: Flow<List<Item>> = flowOf(fakeItems)
    override suspend fun fetchItems() {
        // No-op
    }

}

val fakeItems = listOf(
    Item(333,3,"Item 333"),
    Item(123,1,null),
    Item(222,2,"Item 222"),
    Item(111,1,"Item 111"),
    Item(345,3,null),
    Item(654,6,"Item 111"),
)
