package com.jhonatanOrtiz.myanimecharactersapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
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
                navHostController.navigate(Screen.Animes) {
                    popUpTo(0) {
                        inclusive = true
                    }
                }
            }
        }
        composable(Screen.Animes.route) {
            AnimesRoute { anime ->
                navHostController.navigate(
                    screen = Screen.AnimeCharacters, args = ANIME_ID_KEY to anime.id.toString()
                )
            }
        }
        composable(
            route = Screen.AnimeCharacters.route,
            arguments = listOf(navArgument(ANIME_ID_KEY) { defaultValue = "" })
        ) {
            val animeId = requireNotNull(it.arguments).getString(ANIME_ID_KEY)
                ?: throw IllegalArgumentException("anime_id is null but is required")

            AnimeCharactersRoute(animeId)
        }
    }
}


fun NavHostController.navigate(
    screen: Screen, args: Pair<String, String>? = null, builder: NavOptionsBuilder.() -> Unit = {}
) {
    if (args != null) {
        navigate(screen.withArgs(args), builder)
    } else {
        navigate(screen.route, builder)
    }

}