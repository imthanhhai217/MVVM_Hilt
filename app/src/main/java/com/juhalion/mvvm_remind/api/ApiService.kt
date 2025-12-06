package com.juhalion.mvvm_remind.api

import com.juhalion.mvvm_remind.constants.ConstantApi
import com.juhalion.mvvm_remind.models.CommentResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(ConstantApi.GET_COMMENT)
    suspend fun getComments(): Response<CommentResponse>
}