package com.example.newsjetpack.util

import kotlinx.serialization.Serializable

@Serializable
object HomePageScreen

@Serializable
data class NewsArticleScreen(
    val url: String
)