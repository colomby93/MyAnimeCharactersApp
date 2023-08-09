package com.jhonatanOrtiz.myanimecharactersapp


const val ANIME_ID_KEY = "anime_id"
sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Animes : Screen("animes")
    object AnimeCharacters : Screen("anime_characters/{$ANIME_ID_KEY}")
    object CharacterDetail : Screen("character_details")

    fun withArgs(vararg args: Pair<String, String>): String {
        // replace all keys with values
        var newRoute = route
        args.forEach { (key, value) ->
            newRoute = newRoute.replace("{$key}", value)
        }
        return newRoute
    }
}