package com.hassan.fakeposts.domain.usecase

import com.hassan.fakeposts.domain.entity.Post
import com.hassan.fakeposts.domain.repository.PostRepository
import javax.inject.Inject

class ManagePostUseCase @Inject constructor(
    private val repository: PostRepository
) {

    suspend fun getAllPosts(): List<Post> = repository.getAllPosts()
}