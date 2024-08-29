package com.example.godsviking.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavController
import com.example.godsviking.R
import kotlin.math.roundToInt

@Composable
fun GodsBloodLine(navController: NavController){

    var offsetX by remember { mutableStateOf(0f) }

    // Estados para almacenar el tamaño de la imagen y del contenedor
    var imageWidth by remember { mutableStateOf(0f) }
    var containerWidth by remember { mutableStateOf(0f) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume() // Consume el cambio para evitar que otros gestos lo capten

                    // Calcular nuevo desplazamiento horizontal
                    val newOffsetX = offsetX + dragAmount.x

                    // Calcular el límite máximo de desplazamiento
                    val maxOffset = (imageWidth - containerWidth) / 2

                    // Limitar el desplazamiento para que no vaya más allá de los límites de la imagen
                    offsetX = newOffsetX.coerceIn(-maxOffset, maxOffset)
                }
            }
            .onGloballyPositioned { coordinates ->
                containerWidth = coordinates.size.width.toFloat()
            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.bloodline),
            contentDescription = null,
            contentScale = ContentScale.Crop, // Mantiene la imagen recortada
            modifier = Modifier
                .fillMaxSize()
                .onGloballyPositioned { coordinates ->
                    imageWidth = coordinates.size.width.toFloat()
                }
                .offset { IntOffset(offsetX.roundToInt(), 0) }
        )
    }


    }

