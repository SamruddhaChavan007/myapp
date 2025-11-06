package com.example.myintro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myintro.objects.Routes
import com.example.myintro.ui.components.AnimatedNavigationBar
import com.example.myintro.utils.defaultPortfolioBottomItems

@Composable
fun MainApp() {
    val nav = rememberNavController()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            AnimatedNavigationBar(
                navController = nav,
                items = defaultPortfolioBottomItems()
            )
        }
    ) { inner ->
        NavHost(
            navController = nav,
            startDestination = Routes.Home,   // <-- must exist below
            modifier = Modifier
                .fillMaxSize()
                .padding(inner)
        ) {
            composable(Routes.Home) { AboutScreen() }
            composable(Routes.Education)  { EducationScreen() }
            composable(Routes.Experience) { ExperienceScreen() }
            composable(Routes.Projects)   { ProjectsScreen() }
            composable(Routes.Skills)     { SkillsScreen() }
        }
    }
}

@Composable
fun SkillsScreen() {
    Scaffold(
        Modifier.fillMaxSize().background(Color.Black),
    ) { }
}

@Composable
fun ProjectsScreen() {
    Scaffold(
        Modifier.fillMaxSize().background(Color.Black),
    ) { }
}

@Composable
fun ExperienceScreen() {
    Scaffold(
        Modifier.fillMaxSize().background(Color.Black),
    ) { }
}

@Composable
fun EducationScreen() {
    Scaffold(
        Modifier.fillMaxSize().background(Color.Black),
    ) { }
}

@Composable
fun AboutScreen() {
    Scaffold(
        Modifier.fillMaxSize().background(Color.Black),
    ) { }
}