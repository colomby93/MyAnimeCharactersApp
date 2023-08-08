package com.jhonatanOrtiz.myanimecharactersapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jhonatanOrtiz.myanimecharactersapp.ui.theme.MyAnimeCharactersAppTheme
import com.jhonatanOrtiz.myanimecharactersapp.ui.theme.Start

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAnimeCharactersAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black),

                    ) {
                        val navigationController = rememberNavController()
                        NavHost(navController = navigationController, startDestination = "Start") {
                            composable("Start") { Start(navigationController) }
                            composable("AnimeList") { AnimeList(navigationController) }
                            composable("Characters") { Characters(navigationController) }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAnimeCharactersAppTheme {
    }
}