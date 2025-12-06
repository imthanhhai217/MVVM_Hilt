package com.juhalion.mvvm_remind.modules

import com.juhalion.mvvm_remind.api.ApiService
import com.juhalion.mvvm_remind.constants.ConstantApi
import com.juhalion.mvvm_remind.repositories.CommentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DemoModule {


    @Provides
    @Singleton
    fun providerRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(ConstantApi.BASE_URL).build()
    }

    @Provides
    @Singleton
    fun providerApiServices(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providerCommentRepo(apiService: ApiService): CommentRepository {
        return CommentRepository(apiService)
    }
}