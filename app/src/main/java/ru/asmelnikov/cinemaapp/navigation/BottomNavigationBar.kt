package ru.asmelnikov.cinemaapp.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.asmelnikov.util.Screen


@ExperimentalAnimationApi
@Composable
fun BottomNavigationBar(
    onItemClick: (String) -> Unit
) {
    var selectedIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val items = listOf(
        BottomNavItem(
            "Home",
            Screen.HomeScreen.route,
            Icons.Default.Home
        ),
        BottomNavItem(
            "Watchlist",
            Screen.WatchListScreen.route,
            Icons.Default.List
        ),
        BottomNavItem(
            "Search",
            Screen.SearchScreen.route,
            Icons.Default.Search
        ),
        BottomNavItem(
            "Profile",
            Screen.ProfileScreen.route,
            Icons.Default.Person
        )
    )

    NavigationBar(
        modifier = Modifier
            .height(52.dp),
        containerColor = MaterialTheme.colorScheme.secondary,
        tonalElevation = 10.dp
    ) {
        items.forEachIndexed { index, item ->
            key(item.name) {
                val selected = selectedIndex == index
                val weight = if (selected) 1.5f else 1f
                NavigationBarItem(
                    modifier = Modifier
                        .weight(weight)
                        .fillMaxHeight()
                        .padding(horizontal = if (selected) 4.dp else 0.dp),
                    selected = selected,
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.White,
                        selectedTextColor = Color.White,
                        unselectedIconColor = Color.Gray,
                        unselectedTextColor = Color.Gray
                    ),
                    onClick = {
                        selectedIndex = index
                        onItemClick(item.route)
                    },
                    icon = {
                        AnimatedVisibility(
                            visible = selected,
                            enter = fadeIn() + scaleIn(
                                animationSpec = spring(
                                    dampingRatio = Spring.DampingRatioLowBouncy,
                                    stiffness = Spring.StiffnessLow
                                )
                            )
                        ) {
                            Row(
                                modifier = Modifier.clip(CircleShape),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.name,
                                )
                                Divider(modifier = Modifier.width(5.dp))
                                Text(text = item.name, fontSize = 12.sp)
                            }
                        }
                        AnimatedVisibility(
                            visible = !selected,
                        ) {
                            Icon(imageVector = item.icon, contentDescription = item.name)
                        }
                    })
            }
        }
    }
}


data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector
)