package com.juhalion.mvvm_remind.repositories

import com.juhalion.mvvm_remind.api.ApiService
import com.juhalion.mvvm_remind.network.GenericApiResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommentRepository @Inject constructor(val apiService: ApiService) : GenericApiResponse() {

    suspend fun getAllComments() = apiCall {
        apiService.getComments()
    }
}