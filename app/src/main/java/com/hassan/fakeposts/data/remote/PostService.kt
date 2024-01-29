package com.hassan.fakeposts.data.remote

import com.hassan.fakeposts.data.remote.dto.PostDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {

    @GET("/posts")
    suspend fun getAllPosts(): Response<List<PostDto>>

    @GET("/posts/{ID}")
    suspend fun getPostById(
        @Path("ID") id: String
    ): Response<PostDto>
}