package com.hassan.fakeposts.data.remote

import com.hassan.fakeposts.data.remote.dto.PostDto
import retrofit2.Response
import retrofit2.http.GET

interface PostService {

    @GET("/posts")
    suspend fun getAllPosts(): Response<List<PostDto>>
}