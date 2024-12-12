package com.jackl.jackprojects.naivenetwork.post.domain.models

data class Post(
    val username: String,
    val imageUrl: String,
    val description: String,
    val commentCount: Int,
)
