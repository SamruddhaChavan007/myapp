package com.example.myintro

import android.annotation.SuppressLint
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
import com.example.myintro.learning.SCurveStatic
import com.example.myintro.navigation.AppNavigationGraph
import com.example.myintro.objects.Routes
import com.example.myintro.ui.components.AnimatedNavigationBar
import com.example.myintro.utils.defaultPortfolioBottomItems

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainApp() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            AnimatedNavigationBar(
                navController = navController,
                items = defaultPortfolioBottomItems()
            )
        },
        content = {
            AppNavigationGraph(navController = navController)
        }
    )
}
