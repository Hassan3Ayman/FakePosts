package com.hassan.fakeposts.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostDto(
    @SerialName("userId")
    val userId: String?,
    @SerialName("id")
    val id: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("body")
    val body: String?
)