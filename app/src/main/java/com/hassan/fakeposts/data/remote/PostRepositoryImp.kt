package com.hassan.fakeposts.data.remote

import com.hassan.fakeposts.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImp @Inject constructor(
    private val postService: PostService
): PostRepository{
}