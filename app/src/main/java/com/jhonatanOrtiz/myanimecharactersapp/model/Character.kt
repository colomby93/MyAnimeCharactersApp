package com.jhonatanOrtiz.myanimecharactersapp.model

import androidx.annotation.DrawableRes

data class Character(
    val name: String,
    @DrawableRes val picture: Int
)
