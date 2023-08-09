package com.jhonatanOrtiz.myanimecharactersapp.ui.routes


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jhonatanOrtiz.myanimecharactersapp.R
import com.jhonatanOrtiz.myanimecharactersapp.model.Anime
import com.jhonatanOrtiz.myanimecharactersapp.ui.theme.LightBlack


@Composable
fun AnimesRoute(onAnimeClicked: (Anime) -> Unit) {
    Animes(onAnimeClicked)
}

@Composable
fun Animes(onAnimeClicked: (Anime) -> Unit) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        items(getAnime()) { anime ->
            AnimesItem(
                anime = anime,
                onAnimeClicked = onAnimeClicked
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimesItem(anime: Anime, onAnimeClicked: (Anime) -> Unit) {
    Card(
        onClick = { onAnimeClicked(anime) },
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .padding(start = 4.dp, top = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .background(color = LightBlack)
                .fillMaxSize()
        ) {
            Image(
                modifier = Modifier
                    .width(150.dp)
                    .fillMaxHeight(),
                painter = painterResource(id = anime.picture),
                contentDescription = "one piece",
                contentScale = ContentScale.Fit
            )
            Text(
                text = anime.name,
                modifier = Modifier.align(alignment = Alignment.CenterVertically),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp

            )
        }
    }
}

fun getAnime(): List<Anime> {
    return listOf(
        Anime(id = 0, name = "One piece", picture = R.drawable.ic_one_piece_1),
        Anime(id = 1, name = "naruto", picture = R.drawable.ic_naruto),
        Anime(id = 2, name = "dragon ball", picture = R.drawable.ic_dragon_ball)
    )
}


