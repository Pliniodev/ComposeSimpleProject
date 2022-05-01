package com.pliniodev.composesimpleproject

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pliniodev.composesimpleproject.navigation.NavAction
import com.pliniodev.composesimpleproject.navigation.Screen
import com.pliniodev.composesimpleproject.ui.theme.ComposeSimpleProjectTheme
import com.pliniodev.composesimpleproject.view.*

@Composable
fun flowComposeApp() {
    val navController = rememberNavController()
    val actions = remember(navController) { NavAction(navController) }

    ComposeSimpleProjectTheme{
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route
        ){
            composable(Screen.Home.route){ Home(action = actions.view1) }
            composable(Screen.View1.route){ View1(action = actions.view2) }
            composable(Screen.View2.route){ View2() }
        }
    }
}