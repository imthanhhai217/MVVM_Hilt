package com.juhalion.mvvm_remind.network

import retrofit2.Response

abstract class GenericApiResponse {

    suspend fun <T> apiCall(call: suspend () -> Response<T>): ApiResponse<T> {
        return try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    ApiResponse.Success(response.code(), body)
                } else {
                    ApiResponse.Error(response.code(), message = response.message())
                }
            } else {
                ApiResponse.Error(response.code(), response.message())
            }
        } catch (e: Exception) {
            ApiResponse.Error(500, message = e.localizedMessage ?: "Something went wrong")
        }
    }
}