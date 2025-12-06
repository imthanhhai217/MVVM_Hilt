package com.juhalion.mvvm_remind.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.juhalion.mvvm_remind.models.CommentResponse
import com.juhalion.mvvm_remind.network.ApiResponse
import com.juhalion.mvvm_remind.repositories.CommentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentViewModel @Inject constructor(
    application: Application, private val commentRepository: CommentRepository
) : AndroidViewModel(application) {

    private val _listCommentResult = MutableLiveData<ApiResponse<CommentResponse>>()
    val listCommentResult: LiveData<ApiResponse<CommentResponse>> = _listCommentResult

    fun getAllComment() {
        _listCommentResult.value = ApiResponse.Loading()
        viewModelScope.launch {
            _listCommentResult.value = commentRepository.getAllComments()
        }
    }
}