package com.example.godsviking.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.godsviking.R

@Composable
fun GodsMap(navController: NavController){

    Box(modifier = Modifier.fillMaxSize()){

        Image(painter = painterResource(id = R.drawable.mapviking),
            contentDescription = stringResource(R.string.map_viking),
            modifier = Modifier
                .fillMaxSize()
                .rotate(90f)
                .scale(1.7f),
        contentScale = ContentScale.Fit)
    }



}