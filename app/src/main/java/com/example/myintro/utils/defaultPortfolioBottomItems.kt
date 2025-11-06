package com.example.myintro.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import com.example.myintro.datamodels.BottomDestination
import com.example.myintro.objects.Routes

fun defaultPortfolioBottomItems() = listOf(
    BottomDestination(Routes.Home, "About", Icons.Filled.Person),
    BottomDestination(Routes.Education, "Education", Icons.Filled.Favorite),
    BottomDestination(Routes.Experience, "Experience", Icons.Filled.Star),
    BottomDestination(Routes.Projects, "Projects", Icons.Filled.Home),
    BottomDestination(Routes.Skills, "Skills", Icons.Filled.Star),
)