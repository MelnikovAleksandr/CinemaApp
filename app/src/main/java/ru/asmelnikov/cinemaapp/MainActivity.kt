package ru.asmelnikov.cinemaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.asmelnikov.cinemaapp.navigation.BottomNavigationBar
import ru.asmelnikov.cinemaapp.navigation.NavGraph
import ru.asmelnikov.cinemaapp.ui.theme.CinemaAppTheme
import ru.asmelnikov.util.Screen

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CinemaAppTheme {
                val navController = rememberNavController()
                val currentRoute =
                    navController.currentBackStackEntryAsState().value?.destination?.route


                var bottomBarState by rememberSaveable { (mutableStateOf(false)) }

                bottomBarState = when (currentRoute) {
                    Screen.HomeScreen.route -> true
                    Screen.WatchListScreen.route -> true
                    Screen.SearchScreen.route -> true
                    Screen.ProfileScreen.route -> true
                    else -> false
                }
                Scaffold(
                    bottomBar = {
                        AnimatedVisibility(visible = bottomBarState) {
                            BottomNavigationBar(
                                onItemClick = {
                                    navController.navigate(it) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                })
                        }
                    }
                ) { contentPadding ->
                    NavGraph(navController = navController, paddingValues = contentPadding)
                }
            }
        }
    }
}