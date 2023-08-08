package com.jhonatanOrtiz.myanimecharactersapp

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
import com.jhonatanOrtiz.myanimecharactersapp.model.Characters

@Composable
fun Characters() {
    Column(
        modifier = Modifier.background(Color.Black),
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
            items(getCharacters()) { characters ->
                CharactersItem(characters = characters)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharactersItem(characters: Characters) {
    Card(
        onClick = { },
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .background(color = Color.Black)
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
                painter = painterResource(id = characters.photo),
                contentDescription = "one piece",
                contentScale = ContentScale.Fit
            )
            Text(
                text = characters.nameCharacters,
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


fun getCharacters(): List<Characters> {
    return listOf(
        Characters("Luffy", R.drawable.ic_luffy),
        Characters("Zoro Ronoa", R.drawable.ic_zoro),
        Characters("Nami", R.drawable.ic_nami),
        Characters("Usopp", R.drawable.ic_ussop),
        Characters("Sanji", R.drawable.ic_sanji),
        Characters("Chopper", R.drawable.ic_chopper),
        Characters("Nico Robin", R.drawable.ic_robin),
        Characters("Franky", R.drawable.ic_franky),
        Characters("Brook", R.drawable.ic_brook),
        Characters("Jinbe", R.drawable.ic_jinbe),
        Characters("Nefertary Vivi", R.drawable.ic_nefertary_vivi),
    )
}