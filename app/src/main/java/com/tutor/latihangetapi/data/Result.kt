package com.tutor.latihangetapi.data

import com.tutor.latihangetapi.data.models.Product

sealed class Result<T>(
    val data: T? = null,
    val messages: String? = null
) {
    class Success<T> (data: T?): Result<T>(data)
    class Error<T> (data: T? = null, message: String): Result<T>(data, message)
}