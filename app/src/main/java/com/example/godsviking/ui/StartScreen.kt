package com.example.godsviking.ui

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.godsviking.R
import com.example.godsviking.VikingScreen
import com.example.godsviking.data.DataSource
import com.example.godsviking.data.DataSource.topics
import com.example.godsviking.ui.theme.Viking
import com.example.godsviking.ui.theme.golden

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StartScreen(navController: NavController){

    Scaffold(
        content = {

            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                Image(
                    painter = painterResource(id = R.drawable.vahalla),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(topics) {
                        TopicBox(
                            topic = it,
                            modifier = Modifier
                                .padding(top = 4.dp)
                                .clickable {
                                    when (it.name) {
                                        DataSource.TopicName.DIOSES.name -> navController.navigate(VikingScreen.Gods.name)
                                        DataSource.TopicName.HISTORIA.name -> navController.navigate(VikingScreen.GodsHistory.name)
                                        DataSource.TopicName.LEYENDAS.name -> navController.navigate(VikingScreen.GodsMyth.name)
                                        DataSource.TopicName.MAPA.name -> navController.navigate(VikingScreen.GodsMap.name)
                                        else -> {}
                                    }
                                }
                        )
                    }
                }

            }

        }
    )

    BackHandler {

    }


}



/*
    Topic Box Container in the main screen
 */
@Composable
fun TopicBox(topic: DataSource.Topic, modifier: Modifier) {

    Card(
        modifier = modifier
            .padding(28.dp)
            .fillMaxWidth()
            .height(80.dp)
            .shadow(
                elevation = 12.dp,
                shape = MaterialTheme.shapes.small,
                ambientColor = golden,
                spotColor = golden
            )
            .border(
                width = 1.dp,
                color = Color.White,
                shape = MaterialTheme.shapes.small
            )
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                painter = painterResource(id = topic.imageResId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black.copy(alpha = 0.5f))
            ) {
                Text(
                    text = topic.name,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }


        }
    }

}