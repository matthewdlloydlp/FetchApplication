package com.ml.fetchapplication

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ml.fetchapplication.items.ItemDetailsScreen
import com.ml.fetchapplication.items.ItemsListScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.ListScreen.route) {
        composable(Screen.ListScreen.route) {
            ItemsListScreen {
                navController.navigate(Screen.ItemDetailsScreen.createRoute(it.id))
            }
        }
        composable(Screen.ItemDetailsScreen.route) {
            ItemDetailsScreen {
                navController.popBackStack()
            }
        }
    }
}

sealed class Screen(val route: String) {
    object ListScreen : Screen("list_screen")
    object ItemDetailsScreen : Screen("item_details_screen/{itemId}") {
        fun createRoute(itemId: Int) = "item_details_screen/$itemId"
    }
}
