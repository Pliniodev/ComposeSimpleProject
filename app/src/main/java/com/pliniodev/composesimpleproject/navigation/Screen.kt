package com.pliniodev.composesimpleproject.navigation

import androidx.navigation.NavController

sealed class Screen(val route: String) {
    object Home: Screen(route = "home")
    object View1: Screen(route = "view1")
    object View2: Screen(route = "view2")
}

class NavAction(navController: NavController) {
    val home: () -> Unit = { navController.navigate(Screen.Home.route) }
    val view1: () -> Unit = { navController.navigate(Screen.View1.route) }
    val view2: () -> Unit = { navController.navigate(Screen.View2.route) }
    val navigateBack: () -> Unit = { navController.popBackStack() }
}
