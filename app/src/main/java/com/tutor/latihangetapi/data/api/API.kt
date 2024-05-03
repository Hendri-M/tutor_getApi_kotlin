package com.tutor.latihangetapi.data.api

import com.tutor.latihangetapi.data.models.Products
import retrofit2.http.GET

interface API {

    @GET("products")
    suspend fun getProductList() : Products

    companion object {
        const val BASE_URL = "https://dummyjson.com/"
    }

//    @GET("products/{types}")
//    suspend fun getProductList(
//        @Path("types") types: String,
//        @Query("page") page: Int,
//        @Query("api_key") apiKey: String
//    ) : Products
}