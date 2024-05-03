package com.tutor.latihangetapi.data

import com.tutor.latihangetapi.data.api.API
import com.tutor.latihangetapi.data.models.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class ProductsRepoImpl(private  val api: API): ProductsRepo {

    override suspend fun getProductsLists(): Flow<Result<List<Product>>>{
        return flow {
            val productApi = try {
                api.getProductList()
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Result.Error(data = null, message = "Error load products."))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Result.Error(message = "Error load products."))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(message = "Error load products."))
                return@flow
            }

            emit(Result.Success(productApi.products))
        }
    }
}