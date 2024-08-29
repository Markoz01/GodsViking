package com.example.godsviking.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.DialogHost
import com.example.godsviking.R
import com.example.godsviking.data.DataSource

/*
    Screen about gods info when a god was selected to see his information
 */
@Composable
fun GodInfoScreen(godInfo: DataSource.GodInfo, navController: NavController) {

    var isDialogOpen by remember{mutableStateOf(false)}

    //Background Image
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.muralviking),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )

    }

    //Separator Boxes Container
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        //Box of Image
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {

            Image(
                painter = painterResource(id = godInfo.picture),
                contentDescription = "God",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = 40.dp,
                        bottom = 40.dp,
                        start = 60.dp,
                        end = 60.dp
                    )
                    .border(
                        width = 4.dp,
                        color = Color.LightGray
                    )
                    .clickable { isDialogOpen = true }
            )

        }


        //Boxes of God info
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {

            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

                ExpandableBox(
                    inf = "History",
                    infText = stringResource(id = godInfo.history)
                )

                ExpandableBox(
                    inf = "Power",
                    infText = stringResource(id = godInfo.power)
                )

                ExpandableBox(
                    inf = "Myth",
                    infText = stringResource(id = godInfo.myth)
                )

                ExpandableBox(
                    inf = "Relation",
                    infText = stringResource(id = godInfo.relation)
                )

            }

        }

    }

    // Dialog for enlarged image
    if (isDialogOpen) {
        Dialog(onDismissRequest = { isDialogOpen = false }) {
            val configuration = LocalConfiguration.current
            val screenHeight = configuration.screenHeightDp.dp
            val screenWidth = configuration.screenWidthDp.dp

            val imageHeight = (2 * screenHeight) / 3

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        onClick = { isDialogOpen = false },
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    )
            ) {
                Image(
                    painter = painterResource(id = godInfo.picture),
                    contentDescription = stringResource(R.string.viking_god),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(width = screenWidth, height = imageHeight)
                        .clickable(
                            onClick = { },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        )
                )
            }
        }
    }

}

/*
    Box of info in the screen about gods info
 */
@Composable
fun ExpandableBox(inf: String, infText: String) {
    var expanded by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(targetValue = if (expanded) 180f else 0f, label = "")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(top = 8.dp)
            .border(
                color = Color.LightGray,
                width = 2.dp,
            )
            .clickable { expanded = !expanded }
    ) {

        Image(
            painter = painterResource(id = R.drawable.runeviking),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.arrow_info),
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.LightGray),
                modifier = Modifier
                    .size(60.dp)
                    .padding(start = 16.dp)
                    .rotate(rotation)
            )

            Text(
                text = inf,
                fontSize = 28.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 20.dp)

            )

        }

    }

    AnimatedVisibility(visible = expanded) {
        Text(
            text = infText,
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier
                .background(Color.Black.copy(alpha = 0.7f))
                .padding(16.dp)
                .fillMaxWidth()
        )
    }


}

