package com.tutor.latihangetapi.data

import com.tutor.latihangetapi.data.models.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepo {

    suspend fun getProductsLists() : Flow<Result<List<Product>>>
}