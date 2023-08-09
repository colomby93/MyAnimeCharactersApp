package com.jhonatanOrtiz.myanimecharactersapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jhonatanOrtiz.myanimecharactersapp.ui.routes.AnimeCharactersRoute
import com.jhonatanOrtiz.myanimecharactersapp.ui.routes.AnimesRoute
import com.jhonatanOrtiz.myanimecharactersapp.ui.routes.SplashRoute

@Composable
fun NavigationGraph(
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(navController = navHostController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashRoute {
                navHostController.navigate(Screen.Animes.route) {
                    popUpTo(0){
                        inclusive = true
                    }
                }
            }
        }
        composable(Screen.Animes.route) {
            AnimesRoute { anime ->
                navHostController.navigate(
                    Screen.AnimeCharacters.withArgs(ANIME_ID_KEY to anime.id.toString())
                )
            }
        }
        composable(
            route = Screen.AnimeCharacters.route,
            arguments = listOf(navArgument("anime_id") { defaultValue = "" })
        ) {
            val animeId = requireNotNull(it.arguments).getString(ANIME_ID_KEY)
                ?: throw IllegalArgumentException("anime_id is null but is required")

            AnimeCharactersRoute(animeId)
        }
    }
}