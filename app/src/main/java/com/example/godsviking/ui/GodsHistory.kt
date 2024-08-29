package com.example.godsviking.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.godsviking.R

@Composable
fun HistoryScreen(navController: NavController){

    Box(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()))
    {

        Image(painter = painterResource(id = R.drawable.wood_wall),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize())


        Text(text = stringResource(id = R.string.Gods_History_Info),
            modifier = Modifier.padding(16.dp))

    }

}