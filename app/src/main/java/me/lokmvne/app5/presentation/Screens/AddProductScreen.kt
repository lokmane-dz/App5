package me.lokmvne.app5.presentation.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import me.lokmvne.app5.presentation.viewmodels.AddItemViewModel
import me.lokmvne.app5.utils.MyTextField

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun AddProductScreen(navHostController: NavHostController) {
    val addItemViewModel = hiltViewModel<AddItemViewModel>()
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Add Product")
        Spacer(modifier = Modifier.height(16.dp))
        MyTextField(
            value = addItemViewModel.ItemCodeBar.value.toString(),
            onValueChange = {addItemViewModel.ItemCodeBar.value = it.toInt()},
            trailingIcon =
        )
    }
}