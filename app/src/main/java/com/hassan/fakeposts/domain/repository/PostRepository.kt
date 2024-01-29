package com.hassan.fakeposts.domain.repository

import com.hassan.fakeposts.domain.entity.Post

interface PostRepository{
    suspend fun getAllPosts(): List<Post>
    suspend fun getPostById(id: String): Post
}