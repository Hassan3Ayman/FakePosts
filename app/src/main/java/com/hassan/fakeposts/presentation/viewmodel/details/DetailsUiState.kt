package com.hassan.fakeposts.presentation.viewmodel.details

import com.hassan.fakeposts.domain.entity.Post

data class DetailsUiState(
    val isLoading: Boolean = false,
    val isError: Boolean? = null,
    val post: PostDetailsUiState = PostDetailsUiState()
)

data class PostDetailsUiState(

    val title: String = "",
    val body: String = "",
)

fun Post.toPostDetailsUiState(): PostDetailsUiState = PostDetailsUiState(
    this.title,
    this.body
)