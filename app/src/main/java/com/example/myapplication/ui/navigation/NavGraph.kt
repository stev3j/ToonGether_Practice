package com.example.myapplication.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.ui.screens.*

@ExperimentalFoundationApi
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.screenRoute) {
        composable(Screen.Home.screenRoute) {
            HomeScreen()
        }
        composable(Screen.Week.screenRoute) {
            WebToonScreen()
        }
        composable(Screen.Short.screenRoute) {
            ShortScreen()
        }
        composable(Screen.Community.screenRoute) {
            CommunityScreen()
        }
        composable(Screen.My.screenRoute) {
            MyScreen()
        }
    }
}