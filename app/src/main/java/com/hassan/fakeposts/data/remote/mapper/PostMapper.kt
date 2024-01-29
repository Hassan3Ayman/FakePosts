package com.hassan.fakeposts.data.remote.mapper

import com.hassan.fakeposts.data.remote.dto.PostDto
import com.hassan.fakeposts.domain.entity.Post

fun PostDto.toPost() = Post(
    userId = this.userId ?: "",
    id = this.id ?: "",
    title = this.title ?: "",
    body = this.body ?: "",
)