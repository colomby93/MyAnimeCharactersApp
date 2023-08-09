package com.jhonatanOrtiz.myanimecharactersapp.model

import androidx.annotation.DrawableRes

data class Anime(
    val id: Int,
    val name: String,
    @DrawableRes val picture: Int
)
