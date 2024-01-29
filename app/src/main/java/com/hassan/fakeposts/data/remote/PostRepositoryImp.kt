package com.hassan.fakeposts.data.remote

import com.hassan.fakeposts.data.remote.mapper.toPost
import com.hassan.fakeposts.domain.entity.Post
import com.hassan.fakeposts.domain.repository.PostRepository
import retrofit2.Response
import java.net.UnknownHostException
import javax.inject.Inject

class PostRepositoryImp @Inject constructor(
    private val postService: PostService
) : PostRepository {
    override suspend fun getAllPosts(): List<Post> {
        return wrapResponse { postService.getAllPosts() }.map { it.toPost() }
    }

    private suspend fun <T> wrapResponse(
        function: suspend () -> Response<T>
    ): T {
        try {
            val response = function()
            if (response.isSuccessful) {
                return response.body() ?: throw Exception("Null data")
            } else {
                throw Exception("Something went wrong")
            }
        } catch (e: UnknownHostException) {
            throw Exception("No internet")
        }
    }
}