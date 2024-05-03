package com.tutor.latihangetapi.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tutor.latihangetapi.data.ProductsRepo
import com.tutor.latihangetapi.data.Result
import com.tutor.latihangetapi.data.models.Product
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val productRepo: ProductsRepo
): ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products = _products.asStateFlow()

    val showErrorToast = Channel<Boolean>()

    init {
        viewModelScope.launch {
            productRepo.getProductsLists().collectLatest { 
                result -> when(result) {
                is Result.Error -> {
                    showErrorToast.send(element = true)
                }
                is Result.Success -> {
                    result.data?.let { 
                        products -> _products.update { products }
                    }
                }
            }
            }
        }
    }
}









