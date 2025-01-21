package com.project.mindmap.ui.pages.navbar

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.project.mindmap.ui.pages.community.CommunitiesScreen
import com.project.mindmap.ui.pages.home.HomeScreen
import com.project.mindmap.ui.pages.programs.ProgramLibraryScreen
import com.project.mindmap.ui.pages.therapistis.TherapistsScreen
import com.project.mindmap.ui.pages.elite.EliteScreen
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import com.project.mindmap.ui.theme.NonBoldH4
import com.project.mindmap.ui.theme.NonBoldH4Black


@Composable
fun BottomNavBarComposable(navController: NavController) {
    val bottomNavController = rememberNavController()
    val bottomNavItems = listOf(
        BottomNavItem("home", Icons.Default.Home, "Home"),
        BottomNavItem("program", Icons.Default.ShoppingCart, "Programs"),
        BottomNavItem("therapists", Icons.Default.Person, "Therapists"),
        BottomNavItem("communities", Icons.Default.Face, "Groups"),
        BottomNavItem("elite", Icons.Default.Star, "Elite"),
    )

    Scaffold(
        bottomBar = {
            BottomNavigationBar(bottomNavController, bottomNavItems)
        }
    ) { padding ->
        NavHost(
            navController = bottomNavController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            composable("home") { HomeScreen(navController) }
            composable("program") { ProgramLibraryScreen(navController) }
            composable("therapists") { TherapistsScreen() }
            composable("communities") { CommunitiesScreen() }
            composable("elite") { EliteScreen() }
        }
    }
}

@Composable
fun BottomNavigationBar(
    navController: NavController,
    items: List<BottomNavItem>,
    backgroundColor: Color = Color.White
) {
    NavigationBar(containerColor = backgroundColor, tonalElevation = 4.dp) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = {
                    Text(
                        item.label,
                        style = NonBoldH4Black
                    )
                },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            // Avoid building a large back stack
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}


data class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val label: String
)
