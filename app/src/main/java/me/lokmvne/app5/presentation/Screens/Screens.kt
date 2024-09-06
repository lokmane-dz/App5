package me.lokmvne.app5.presentation.Screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

const val ADD_PRODUCT_SCREEN = "add_product"
const val GET_PRODUCT_INFO_SCREEN = "get_product_info"
const val SELL_SCREEN = "sell"

sealed class Screens(
    val route: String,
    val title: String,
    val icon: ImageVector,
) {
    object AddProductScreen : Screens(
        route = ADD_PRODUCT_SCREEN,
        title = "Add",
        icon = Icons.Default.Add,
    )

    object GetProductInfoScreen : Screens(
        route = GET_PRODUCT_INFO_SCREEN,
        title = "Info",
        icon = Icons.Default.Info,
    )

    object SellScreen : Screens(
        route = SELL_SCREEN,
        title = "Sell",
        icon = Icons.Default.ShoppingCart,
    )
}