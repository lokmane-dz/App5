package me.lokmvne.app5.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import me.lokmvne.app5.data.Item
import me.lokmvne.app5.repository.repository
import javax.inject.Inject

@HiltViewModel
class AddItemViewModel @Inject constructor(private val repository: repository) : ViewModel() {

    var _ItemTitle = MutableStateFlow<String>("")
    var ItemTitle = _ItemTitle.asStateFlow()

    var _ItemPrice = MutableStateFlow<Float>(0.0f)
    var ItemPrice = _ItemPrice.asStateFlow()

    var _ItemQuantity = MutableStateFlow<Int>(0)
    var ItemQuantity = _ItemQuantity.asStateFlow()

    var _ItemCodeBar = MutableStateFlow<Int>(0)
    var ItemCodeBar = _ItemCodeBar.asStateFlow()

    val _AddItemResult = MutableStateFlow<String>("")
    val AddItemResult = _AddItemResult.asStateFlow()

    fun AddItem(item: Item) {
        viewModelScope.launch {
            repository.AddItem(item)
        }
    }
}