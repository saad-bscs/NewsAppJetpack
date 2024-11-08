package com.example.newsjetpack.screens

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.newsjetpack.util.MyToolbar

@Composable
fun NewsArticlePage(url: String, modifier: Modifier = Modifier) {

    Scaffold(
        topBar = {
            MyToolbar(
                title = "Article Screen"
            )
        }
    ) { paddingValues ->

        Column(modifier = Modifier.padding(paddingValues)) {
            AndroidView(factory = { context ->
                WebView(context).apply {
                    settings.javaScriptEnabled = true
                    webViewClient = WebViewClient()
                    loadUrl(url)
                }
            })
        }
    }
}