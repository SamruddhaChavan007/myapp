package com.example.myintro.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.WorkHistory
import com.example.myintro.datamodels.BottomDestination
import com.example.myintro.objects.Routes

fun defaultPortfolioBottomItems() = listOf(
    BottomDestination(Routes.Home, "About", Icons.Filled.Person),
    BottomDestination(Routes.Education, "Education", Icons.Filled.School),
    BottomDestination(Routes.Experience, "Experience", Icons.Filled.WorkHistory),
    BottomDestination(Routes.Projects, "Projects", Icons.Filled.Apps),
    BottomDestination(Routes.Skills, "Skills", Icons.Filled.Psychology),
)