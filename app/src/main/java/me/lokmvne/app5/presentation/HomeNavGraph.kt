package me.lokmvne.app5.presentation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import me.lokmvne.app5.presentation.Screens.ADD_PRODUCT_SCREEN
import me.lokmvne.app5.presentation.Screens.AddProductScreen
import me.lokmvne.app5.presentation.Screens.GET_PRODUCT_INFO_SCREEN
import me.lokmvne.app5.presentation.Screens.GetProductInfoScreen
import me.lokmvne.app5.presentation.Screens.SELL_SCREEN
import me.lokmvne.app5.presentation.Screens.SellScreen

@Composable
fun HomeNavGraph(
    navController: NavHostController,
    context: Context,
    lifecycleScope: LifecycleCoroutineScope
) {
    NavHost(navController = navController, startDestination = GET_PRODUCT_INFO_SCREEN) {
        composable(GET_PRODUCT_INFO_SCREEN) {
            GetProductInfoScreen(
                navController,
                context = context,
                lifecycleScope = lifecycleScope
            )
        }
        composable(ADD_PRODUCT_SCREEN) {
            AddProductScreen(navController)
        }
        composable(SELL_SCREEN) {
            SellScreen(navController)
        }
    }
}