package com.example.godsviking.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.godsviking.R
import com.example.godsviking.VikingScreen
import com.example.godsviking.data.DataSource

@Composable
fun GodsMythScreen(navController: NavController){

    val list = DataSource.mythsInfo

    Box(modifier = Modifier.fillMaxSize()){

        Image(painter = painterResource(id = R.drawable.muralviking),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop)

        LazyColumn {
            items(list){
                    item -> GodMythBar(myth = item, navController)
            }
        }

    }



}

@Composable
fun GodMythBar(myth: DataSource.Myth, navController: NavController){

    val mythInfo = stringResource(id = myth.mythInfo)

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
        .height(56.dp)
        .clip(shape = RoundedCornerShape(28.dp))
        .background(color = MaterialTheme.colorScheme.inversePrimary),
        contentAlignment = Alignment.Center
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Text(text = stringResource(id = myth.mythName),
                modifier = Modifier.padding(start = 8.dp),
                )

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                onClick = { navController.navigate("${VikingScreen.GodsMythInfo.name}/${mythInfo}") },
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 16.dp)
                    .background(
                        color = MaterialTheme.colorScheme.secondary,
                        shape = CircleShape
                    )
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Arrow",
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            }

        }

    }

}


@Composable
fun GodMythInfo(mythInfo: String,navController: NavController){

    Box(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()))
    {

        Image(painter = painterResource(id = R.drawable.wood_wall),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize())


        Text(text = mythInfo,
            modifier = Modifier.padding(16.dp))

    }

}