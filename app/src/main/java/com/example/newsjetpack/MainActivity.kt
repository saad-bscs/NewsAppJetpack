package com.example.newsjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.newsjetpack.screens.HomePage
import com.example.newsjetpack.screens.NewsArticlePage
import com.example.newsjetpack.ui.theme.NewsJetpackTheme
import com.example.newsjetpack.util.HomePageScreen
import com.example.newsjetpack.util.NewsArticleScreen
import com.example.newsjetpack.viewmodel.NewsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val newsViewModel = ViewModelProvider(this)[NewsViewModel::class]
        setContent {

            val navController = rememberNavController()

            NewsJetpackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        NavHost(navController, startDestination = HomePageScreen) {
                            composable<HomePageScreen> {
                                HomePage(newsViewModel, navController)
                            }

                            composable<NewsArticleScreen> {
                                val args = it.toRoute<NewsArticleScreen>()
                                NewsArticlePage(args.url)
                            }
                        }

                    }
                }
            }
        }
    }
}