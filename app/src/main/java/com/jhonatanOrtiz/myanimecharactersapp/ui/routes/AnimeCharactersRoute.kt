package com.jhonatanOrtiz.myanimecharactersapp.ui.routes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import com.jhonatanOrtiz.myanimecharactersapp.model.Character

@Composable
fun AnimeCharactersRoute(animeId: String) {
    AnimeCharacters(animeId = animeId)
}

@Composable
fun AnimeCharacters(animeId: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Personajes del anime",
            modifier = Modifier,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.White
        )
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(getCharacters(animeId)) { characters ->
                CharactersItem(character = characters)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharactersItem(character: Character) {
    Card(
        onClick = { },
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .padding(start = 4.dp, top = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxSize()
        ) {
            Image(
                modifier = Modifier
                    .width(150.dp)
                    .fillMaxHeight(),
                painter = painterResource(id = character.picture),
                contentDescription = "one piece",
                contentScale = ContentScale.Fit
            )
            Text(
                text = character.name,
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically)
                    .padding(10.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.Black
            )
        }
    }
}


fun getCharacters(animeId: String): List<Character> {
    return when (animeId) {
        "0" -> {
            listOf(
                Character("Luffy", R.drawable.ic_luffy),
                Character("Zoro Ronoa", R.drawable.ic_zoro),
                Character("Nami", R.drawable.ic_nami),
                Character("Usopp", R.drawable.ic_ussop),
                Character("Sanji", R.drawable.ic_sanji),
                Character("Chopper", R.drawable.ic_chopper),
                Character("Nico Robin", R.drawable.ic_robin),
                Character("Franky", R.drawable.ic_franky),
                Character("Brook", R.drawable.ic_brook),
                Character("Jinbe", R.drawable.ic_jinbe),
                Character("Nefertary Vivi", R.drawable.ic_nefertary_vivi),
            )
        }

        "1" -> {
            listOf(
                Character("Naruto", R.drawable.ic_luffy),
                Character("Sakura", R.drawable.ic_zoro),
            )
        }

        else -> {
            listOf()
        }
    }
}
