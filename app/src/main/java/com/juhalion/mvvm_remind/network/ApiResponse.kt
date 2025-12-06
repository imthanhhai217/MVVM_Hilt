package com.juhalion.mvvm_remind.network

sealed class ApiResponse<T>(open val code: Int? = null, val data: T? = null, val message: String? = null) {
    class Loading<T>() : ApiResponse<T>()
    class Success<T>(code: Int, data: T) : ApiResponse<T>(code, data)
    class Error<T>(code: Int, message: String) : ApiResponse<T>(code = code, message = message)
}