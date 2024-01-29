package com.hassan.fakeposts.presentation.viewmodel.home

import com.hassan.fakeposts.domain.entity.Post

data class HomeUiState(
    val isLoading: Boolean = false,
    val isError: Boolean? = null,
    val posts: List<PostUiState> = emptyList()
)

data class PostUiState(
    val userId: String = "",
    val id: String = "",
    val title: String = "",
    val body: String = "",
)

fun Post.toPostUiState(): PostUiState = PostUiState(
    this.userId,
    this.id,
    this.title,
    this.body
)