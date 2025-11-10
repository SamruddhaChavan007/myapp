package com.example.myintro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myintro.objects.Routes
import com.example.myintro.ui.screens.AboutScreen
import com.example.myintro.ui.screens.EducationScreen
import com.example.myintro.ui.screens.ExperienceScreen
import com.example.myintro.ui.screens.ProjectsScreen
import com.example.myintro.ui.screens.SkillsScreen


@Composable
fun AppNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home
    ) {
        composable(Routes.Home) {
            AboutScreen() // “About Me”
        }
        composable(Routes.Education) {
            EducationScreen()
        }
        composable(Routes.Experience) {
            ExperienceScreen()
        }
        composable(Routes.Projects) {
            ProjectsScreen()
        }
        composable(Routes.Skills) {
            SkillsScreen()
        }
    }
}