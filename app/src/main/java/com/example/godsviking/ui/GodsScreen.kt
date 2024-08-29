package com.example.godsviking.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.godsviking.R
import com.example.godsviking.VikingScreen
import com.example.godsviking.data.DataSource

@Composable
fun GodsScreen(list: List<DataSource.CardGodInfoGrid>, navController: NavController){
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {

        items(list) { item ->
            GodsGridCard(item,navController)
        }

    }
}

/*
    Element of the grid of gods
 */
@Composable
fun GodsGridCard(card: DataSource.CardGodInfoGrid, navController: NavController){

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .clickable {
            navController.navigate("${VikingScreen.GodsInf.name}/${card.name}")
        }
    ){

        Image(painter = painterResource(R.drawable.wallvikingrunes),
            contentDescription = "God Card",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize())

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.3f))
        )

        Column(verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()){

            Image(painter = painterResource(card.picture),
                contentDescription = "God Card",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = Color.LightGray,
                        shape = CircleShape
                    )
            )

            Text(text = card.name,
                fontSize = 24.sp,
                color = Color.White)

        }

    }

}