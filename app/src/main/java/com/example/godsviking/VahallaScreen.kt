package com.example.godsviking

import android.util.Log
import android.view.View
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.godsviking.data.DataSource
import com.example.godsviking.ui.GodInfoScreen
import com.example.godsviking.ui.GodMythInfo
import com.example.godsviking.ui.GodsBloodLine
import com.example.godsviking.ui.GodsMap
import com.example.godsviking.ui.GodsMythScreen
import com.example.godsviking.ui.GodsScreen
import com.example.godsviking.ui.HistoryScreen
import com.example.godsviking.ui.LoadScreen
import com.example.godsviking.ui.StartScreen
import com.example.godsviking.ui.viewModel.VikingViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*Class Enum with name of screens

 */
enum class VikingScreen(@StringRes val title: Int) {
    Splash(title = R.string.app_name),
    Start(title = R.string.start_screen),
    Gods(title = R.string.gods),
    GodsInf(title = R.string.gods_inf),
    GodsHistory(title = R.string.gods_history),
    GodsMyth(title = R.string.myth),
    GodsMythInfo(title = R.string.myth_info),
    GodsMap(title = R.string.map_god),
}

/*
App bar
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VikingAppBar(
    title: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(
            text = title,
            modifier = Modifier
                .padding(start = 8.dp)
                .wrapContentWidth(align = Alignment.CenterHorizontally),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}


/*
VikingApp
 */
@Composable
fun VikingApp(
    viewModel: VikingViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentRoute = backStackEntry?.destination?.route
    val currentScreen = when {
        currentRoute == VikingScreen.Splash.name -> VikingScreen.Splash
        currentRoute == VikingScreen.Start.name -> VikingScreen.Start
        currentRoute == VikingScreen.Gods.name -> VikingScreen.Gods
        currentRoute == VikingScreen.GodsHistory.name -> VikingScreen.GodsHistory
        currentRoute == VikingScreen.GodsMyth.name -> VikingScreen.GodsMyth
        currentRoute == VikingScreen.GodsMap.name -> VikingScreen.GodsMap
        currentRoute?.startsWith(VikingScreen.GodsInf.name) == true -> VikingScreen.GodsInf
        currentRoute?.startsWith(VikingScreen.GodsMythInfo.name) == true -> VikingScreen.GodsMythInfo
        else -> VikingScreen.Start
    }

    Scaffold(
        topBar = {
            if (currentScreen != VikingScreen.Splash) {
                val title = if(currentScreen == VikingScreen.GodsInf){
                    backStackEntry?.arguments?.getString("godName") ?:
                    stringResource(VikingScreen.GodsInf.title)
                }else{
                    stringResource(currentScreen.title)
                }
                VikingAppBar(
                    title = title,
                    canNavigateBack = if (currentScreen == VikingScreen.Start) {
                        navController.previousBackStackEntry == null
                    } else {
                        navController.previousBackStackEntry != null
                    },
                    navigateUp = { navController.navigateUp() }
                )
            }
        }
    ) { innerPadding ->
        val paddingValues = if (currentScreen == VikingScreen.Splash) {
            PaddingValues(0.dp)
        } else {
            innerPadding
        }

        NavHost(
            navController = navController,
            startDestination = VikingScreen.Splash.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            composable(route = VikingScreen.Splash.name) {
                LoadScreen(navController = navController)
            }
            composable(route = VikingScreen.Start.name) {
                StartScreen(navController = navController)
            }
            composable(route = VikingScreen.Gods.name) {
                GodsScreen(list = DataSource.godsCardInfoGrid, navController = navController)
            }
            composable(route = "${VikingScreen.GodsInf.name}/{godName}") { backStackEntry ->
                val godName = backStackEntry.arguments?.getString("godName")
                val god = DataSource.godsInfo[godName]
                god?.let { GodInfoScreen(godInfo = it, navController = navController) }
            }
            composable(route = VikingScreen.GodsHistory.name){
                HistoryScreen(navController = navController)
            }
            composable(route = VikingScreen.GodsMyth.name){
                GodsMythScreen(navController = navController)
            }
            composable(route = "${VikingScreen.GodsMythInfo.name}/{mythInfo}"){
                val mythInfo = backStackEntry?.arguments?.getString("mythInfo")
                mythInfo?.let { it1 -> GodMythInfo(mythInfo = it1, navController = navController) }
            }
            composable(route = VikingScreen.GodsMap.name){
                GodsMap(navController = navController)
            }

        }
    }
}

